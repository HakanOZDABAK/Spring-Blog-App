package com.hakanozdabak.BlogApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadResponse {

    private int id;
    private String fileName;
    private String fileUri;
    private String fileDownloadUri;
    private long fileSize;
    private String postId;
}