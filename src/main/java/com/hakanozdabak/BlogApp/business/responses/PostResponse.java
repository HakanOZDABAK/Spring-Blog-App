package com.hakanozdabak.BlogApp.business.responses;

import com.hakanozdabak.BlogApp.entities.concretes.PostUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private String postName;
    private String postDetail;
    private PostUser postUser;
}
