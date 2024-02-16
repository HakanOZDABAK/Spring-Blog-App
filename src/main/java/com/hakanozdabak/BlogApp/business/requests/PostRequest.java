package com.hakanozdabak.BlogApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private  String id;
    private String postName;
    private String postDetail;
}
