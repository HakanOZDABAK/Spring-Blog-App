package com.hakanozdabak.BlogApp.business.concretes;

import com.hakanozdabak.BlogApp.business.abstracts.AuthService;
import com.hakanozdabak.BlogApp.business.requests.AuthenticationRequest;
import com.hakanozdabak.BlogApp.business.requests.RegisterRequest;
import com.hakanozdabak.BlogApp.business.responses.AuthenticationResponse;
import com.hakanozdabak.BlogApp.business.rules.UserBusinessRules;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.UserRepository;
import com.hakanozdabak.BlogApp.entities.concretes.Role;
import com.hakanozdabak.BlogApp.entities.concretes.User;

import com.hakanozdabak.BlogApp.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final org.springframework.security.authentication.AuthenticationManager authenticationManager;
    private UserBusinessRules userBusinessRules;
    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .profileName(registerRequest.getProfileName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        this.userBusinessRules.checkIfUserEmailExists(registerRequest.getEmail());
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user =userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user.getEmail());
        return AuthenticationResponse.builder()
                .profileName(user.getProfileName())
                .id(user.getId())
                .token(jwtToken)
                .build();

    }
    }

