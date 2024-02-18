package com.hakanozdabak.BlogApp.business.requests;

import com.hakanozdabak.BlogApp.business.responses.GetPostUserResponse;
import com.hakanozdabak.BlogApp.entities.concretes.PostUser;
import com.hakanozdabak.BlogApp.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {

    private  int id;
    private String postName;
    private String postDetail;
    private PostUser user;

}
