package com.hakanozdabak.BlogApp.business.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserPostResponse {

    private int id;
    private String postName;
    private String postDetail;
}
