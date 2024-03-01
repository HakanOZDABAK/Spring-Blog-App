package com.hakanozdabak.BlogApp.business.requests;

import com.hakanozdabak.BlogApp.entities.concretes.BlogPost;
import com.hakanozdabak.BlogApp.entities.concretes.BlogUser;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileRequest {


    private int id;


    private String fileName;

    private String fileUri;

    private String fileDownloadUri;

    private long fileSize;

    private String uploaderName;
    private BlogUser blogUser;
    private BlogPost post;
}
