package com.hakanozdabak.BlogApp.business.abstracts;

import com.hakanozdabak.BlogApp.entities.concretes.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(String email);
    RefreshToken verifyExpiration(RefreshToken token);
    Optional<RefreshToken> findByToken(String token);
}
