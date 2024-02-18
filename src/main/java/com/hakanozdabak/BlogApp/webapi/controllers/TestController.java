package com.hakanozdabak.BlogApp.webapi.controllers;

import com.hakanozdabak.BlogApp.business.abstracts.TestService;
import com.hakanozdabak.BlogApp.entities.concretes.Test;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController("/api/v1/tests")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class TestController {
    private TestService testService;

    @PostMapping("/")
    public void add(Test test){
         this.testService.add(test);
    }

}
