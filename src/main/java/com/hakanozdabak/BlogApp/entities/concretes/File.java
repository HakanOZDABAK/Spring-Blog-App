package com.hakanozdabak.BlogApp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

 private String fileName;
   private String fileUri;
   private String fileDownloadUri;
  private long fileSize;
  private String uploaderName;
}
