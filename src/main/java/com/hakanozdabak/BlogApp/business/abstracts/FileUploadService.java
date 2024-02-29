package com.hakanozdabak.BlogApp.business.abstracts;

import java.util.List;

public interface FileUploadService {
     FileUploadResponse uploadFile(MultipartFile file, String uploaderName) throws IOException;
     Resource fetchFileAsResource(String fileName) throws FileNotFoundException;
     List<FileDetails> getAllFiles();
}
