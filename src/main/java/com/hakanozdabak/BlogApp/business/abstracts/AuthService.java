package com.hakanozdabak.BlogApp.business.abstracts;


import com.hakanozdabak.BlogApp.business.requests.AuthenticationRequest;
import com.hakanozdabak.BlogApp.business.requests.RegisterRequest;
import com.hakanozdabak.BlogApp.business.responses.AuthenticationResponse;

public interface AuthService {

    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest registerRequest);

}
