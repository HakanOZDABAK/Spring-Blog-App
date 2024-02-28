package com.hakanozdabak.BlogApp.business.requests;

import com.hakanozdabak.BlogApp.entities.concretes.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String password;
    private String profileName;
    private Role role;
}
