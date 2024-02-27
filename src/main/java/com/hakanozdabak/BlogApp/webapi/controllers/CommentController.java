package com.hakanozdabak.BlogApp.webapi.controllers;

import com.hakanozdabak.BlogApp.business.abstracts.CommentService;
import com.hakanozdabak.BlogApp.business.requests.CommentRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/addComment")
    public void add(@RequestBody CommentRequest commentRequest){
        this.commentService.add(commentRequest);
    }
}
