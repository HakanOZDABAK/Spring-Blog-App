package com.hakanozdabak.BlogApp.business.responses;

import com.hakanozdabak.BlogApp.entities.concretes.BlogUser;
import com.hakanozdabak.BlogApp.entities.concretes.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private String postName;
    private String postDetail;
    private BlogUser blogUser;
    private List<GetCommentResponse> comments;
}
