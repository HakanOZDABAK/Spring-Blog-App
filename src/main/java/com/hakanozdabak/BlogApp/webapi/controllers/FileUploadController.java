package com.hakanozdabak.BlogApp.webapi.controllers;

import com.hakanozdabak.BlogApp.business.abstracts.FileUploadService;
import com.hakanozdabak.BlogApp.business.responses.FileUploadResponse;
import com.hakanozdabak.BlogApp.core.utilites.exceptions.BusinessException;
import com.hakanozdabak.BlogApp.entities.concretes.FileDetail;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/files")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class FileUploadController {


    private FileUploadService fileUploadService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<FileDetail> getAllFiles() {
        return this.fileUploadService.getAllFiles();
    }

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFiles(@RequestParam("name") String name
            , @RequestParam("files") MultipartFile[] files) {

        try {
            List<FileUploadResponse> fileUploadResponses =
                    Arrays.stream(files).map(file -> {
                        try {
                            return fileUploadService.uploadFile(file, name);
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    }).collect(Collectors.toList());

            return new ResponseEntity<>(fileUploadResponses, HttpStatus.OK);
        } catch (UncheckedIOException e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (BusinessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Object> downloadFile(@PathVariable String fileName,
                                               HttpServletRequest request) {

        try {
            Resource resource = this.fileUploadService.fetchFileAsResource(fileName);
            String contentType =
                    request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}