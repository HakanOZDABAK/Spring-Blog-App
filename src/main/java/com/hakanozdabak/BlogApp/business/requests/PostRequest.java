package com.hakanozdabak.BlogApp.business.requests;

import com.hakanozdabak.BlogApp.entities.concretes.BlogUser;
import com.hakanozdabak.BlogApp.entities.concretes.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequest {

    private  int postId;
    private String postName;
    private String postDetail;
    private BlogUser user;
    private Blob image;


}
