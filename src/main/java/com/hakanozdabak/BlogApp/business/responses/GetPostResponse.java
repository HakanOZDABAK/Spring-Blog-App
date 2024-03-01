package com.hakanozdabak.BlogApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostResponse {

    private int postId;
    private String postName;
    private String postDetail;
}
