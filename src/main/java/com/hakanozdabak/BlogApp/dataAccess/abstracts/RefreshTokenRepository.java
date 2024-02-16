package com.hakanozdabak.BlogApp.dataAccess.abstracts;

import com.hakanozdabak.BlogApp.entities.concretes.RefreshToken;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer> {


    Optional<RefreshToken> findByToken(String token);
}
