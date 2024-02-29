package com.hakanozdabak.BlogApp.business.abstracts;

import com.hakanozdabak.BlogApp.entities.concretes.File;
import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileUploadService {
     FileUploadResponse uploadFile(MultipartFile file, String uploaderName) throws IOException;
     Resource fetchFileAsResource(String fileName) throws FileNotFoundException;
     List<File> getAllFiles();
}
