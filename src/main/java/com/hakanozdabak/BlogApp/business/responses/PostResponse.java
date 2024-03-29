package com.hakanozdabak.BlogApp.business.responses;

import com.hakanozdabak.BlogApp.entities.concretes.BlogImage;
import com.hakanozdabak.BlogApp.entities.concretes.BlogUser;
import com.hakanozdabak.BlogApp.entities.concretes.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {


    private int id;
    private String postName;
    private String postDetail;
    private BlogUser blogUser;
    private List<GetCommentResponse> comments;
    private List<BlogImage> blogImage;
}
