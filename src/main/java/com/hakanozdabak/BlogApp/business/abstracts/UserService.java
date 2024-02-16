package com.hakanozdabak.BlogApp.business.abstracts;

import com.hakanozdabak.BlogApp.business.responses.UserResponse;
import com.hakanozdabak.BlogApp.entities.concretes.User;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();
}
