package com.hakanozdabak.BlogApp.business.concretes;


import com.hakanozdabak.BlogApp.business.abstracts.FileUploadService;
import com.hakanozdabak.BlogApp.business.responses.FileUploadResponse;
import com.hakanozdabak.BlogApp.core.utilites.exceptions.BusinessException;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.FileRepository;
import com.hakanozdabak.BlogApp.entities.concretes.FileDetail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class FileUploadManager implements FileUploadService {

    public FileUploadManager() throws IOException {}

@Autowired
    private FileRepository fileDetailsRepository;

    private final Path UPLOAD_PATH;

    {
        try {
            UPLOAD_PATH = Paths.get(new ClassPathResource("").getFile().getAbsolutePath()
                    + File.separator + "static"
                    + File.separator + "image");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileUploadResponse uploadFile(MultipartFile file,
                                         String uploaderName) throws IOException {
        if (!Files.exists(UPLOAD_PATH)) {
            Files.createDirectories(UPLOAD_PATH);
        }

        // file format validation
        if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
            throw new BusinessException("only .jpeg and .png images are " + "supported");
        }

        String timeStampedFileName = new SimpleDateFormat("ssmmHHddMMyyyy")
                .format(new Date()) + "_" + file.getOriginalFilename();

        Path filePath = UPLOAD_PATH.resolve(timeStampedFileName);
        Files.copy(file.getInputStream(), filePath);

        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/image/").path(timeStampedFileName).toUriString();

        String fileDownloadUri =
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/file/download/").path(timeStampedFileName).toUriString();

        FileDetail fileDetails = new FileDetail(file.getOriginalFilename(),
                fileUri,
                fileDownloadUri, file.getSize(), uploaderName);

        this.fileDetailsRepository.save(fileDetails);

        FileUploadResponse fileUploadResponse =
                new FileUploadResponse(fileDetails.getId(),
                        file.getOriginalFilename(), fileUri, fileDownloadUri,
                        file.getSize(),
                        uploaderName);

        return fileUploadResponse;
    }

    @Override
    public Resource fetchFileAsResource(String fileName) throws FileNotFoundException {

        try {
            Path filePath = UPLOAD_PATH.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }

    @Override
    public List<FileDetail> getAllFiles() {
        return this.fileDetailsRepository.findAll();
    }

}