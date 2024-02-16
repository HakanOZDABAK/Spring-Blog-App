package com.hakanozdabak.BlogApp.business.concretes;

import com.hakanozdabak.BlogApp.business.abstracts.RefreshTokenService;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.RefreshTokenRepository;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.UserRepository;
import com.hakanozdabak.BlogApp.entities.concretes.RefreshToken;
import com.hakanozdabak.BlogApp.entities.concretes.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RefreshTokenManager implements RefreshTokenService {
    private RefreshTokenRepository refreshTokenRepository;
    private UserRepository userRepository;

    @Override
    @Transactional
    public RefreshToken createRefreshToken(String email) {
        Optional<User> existUser = userRepository.findByEmail(email);

        if (existUser.isPresent()) {
            // Find existing refresh token for the user
            Optional<RefreshToken> existingToken = refreshTokenRepository.findByUserId(existUser.get().getId());

            RefreshToken refreshToken;

            if (existingToken.isPresent()) {
                // If there is an existing token, update it
                refreshToken = existingToken.get();
                refreshToken.setToken(UUID.randomUUID().toString());
                refreshToken.setExpiryDate(Instant.now().plusMillis(600000)); // 10 min
            } else {
                // If there is no existing token, create a new one
                refreshToken = RefreshToken.builder()
                        .user(null) // Since we're only using user_id, set user to null
                        .id(existUser.get().getId()) // Set the user_id
                        .token(UUID.randomUUID().toString())
                        .expiryDate(Instant.now().plusMillis(600000)) // 10 min
                        .build();
            }

            // Save the refresh token
            return this.refreshTokenRepository.save(refreshToken);
        } else {
            // Handle the case where the user does not exist
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken()+"Refresh token was expired. Please make a new signin requst");
        }
        return token;
    }
}

