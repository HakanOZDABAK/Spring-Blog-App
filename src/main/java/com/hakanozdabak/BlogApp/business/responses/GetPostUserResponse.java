package com.hakanozdabak.BlogApp.business.responses;

import com.hakanozdabak.BlogApp.entities.concretes.Post;
import com.hakanozdabak.BlogApp.entities.concretes.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostUserResponse {

        private String firstName;
        private String lastName;

}
