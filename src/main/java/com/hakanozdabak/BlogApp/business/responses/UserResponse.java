package com.hakanozdabak.BlogApp.business.responses;

import com.hakanozdabak.BlogApp.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String profileName;
    private Role role;

    private List<GetPostResponse> posts;

}
