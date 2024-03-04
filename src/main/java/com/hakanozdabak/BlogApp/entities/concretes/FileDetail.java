package com.hakanozdabak.BlogApp.entities.concretes;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "file_details")
@Data
@NoArgsConstructor
public class FileDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String fileName;
    @Column
    private String fileUri;
    @Column
    private String fileDownloadUri;
    @Column
    private long fileSize;
    @Column
    private String uploaderName;

    public FileDetail(String fileName, String fileUri,
                       String fileDownloadUri, long fileSize,
                       String uploaderName) {

        this.fileName = fileName;
        this.fileUri = fileUri;
        this.fileDownloadUri = fileDownloadUri;
        this.fileSize = fileSize;
        this.uploaderName = uploaderName;
    }

}