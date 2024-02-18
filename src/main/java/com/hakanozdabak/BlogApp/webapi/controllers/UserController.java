package com.hakanozdabak.BlogApp.webapi.controllers;

import com.hakanozdabak.BlogApp.business.abstracts.UserService;
import com.hakanozdabak.BlogApp.business.responses.UserResponse;
import com.hakanozdabak.BlogApp.entities.concretes.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        return ResponseEntity.ok(this.userService.getAllUsers()) ;
    }
}
