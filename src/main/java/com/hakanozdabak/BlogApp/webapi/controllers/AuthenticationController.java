package com.hakanozdabak.BlogApp.webapi.controllers;


import com.hakanozdabak.BlogApp.business.abstracts.AuthService;
import com.hakanozdabak.BlogApp.business.abstracts.RefreshTokenService;
import com.hakanozdabak.BlogApp.business.requests.AuthenticationRequest;
import com.hakanozdabak.BlogApp.business.requests.RefreshTokenRequest;
import com.hakanozdabak.BlogApp.business.requests.RegisterRequest;
import com.hakanozdabak.BlogApp.business.responses.AuthenticationResponse;
import com.hakanozdabak.BlogApp.entities.concretes.RefreshToken;
import com.hakanozdabak.BlogApp.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest registerRequest
    ) {
         authService.register(registerRequest);
         return "User Successfully Added";
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse auth(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(authenticationRequest.getEmail());

        return AuthenticationResponse.builder()
                .accessToken(String.valueOf(authService.authenticate(authenticationRequest).getToken()))
                .profileName(String.valueOf(authService.authenticate(authenticationRequest).getProfileName()))
                .token(refreshToken.getToken())
                .build();


    }
    @PostMapping("/refresh")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return refreshTokenService.findByToken(refreshTokenRequest.getToken())
                 .map(refreshTokenService::verifyExpiration)
                 .map(RefreshToken::getUser)
                 .map(user ->{String accessToken = jwtService.generateToken(user.getEmail());
                   return AuthenticationResponse.builder()
                         .accessToken(accessToken)
                         .token(refreshTokenRequest.getToken())
                         .build();
                 }).orElseThrow(()->new RuntimeException("Refresh token is not in database'"));

    }
}
