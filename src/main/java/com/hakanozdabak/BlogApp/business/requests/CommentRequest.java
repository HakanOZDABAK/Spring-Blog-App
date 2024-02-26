package com.hakanozdabak.BlogApp.business.requests;

import com.hakanozdabak.BlogApp.entities.concretes.BlogUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequest {
    private int commentId;
    private String commentDetail;
    private BlogUser blogUser;


}
