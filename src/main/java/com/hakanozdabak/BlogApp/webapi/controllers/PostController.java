package com.hakanozdabak.BlogApp.webapi.controllers;


import com.hakanozdabak.BlogApp.business.abstracts.PostService;
import com.hakanozdabak.BlogApp.business.requests.PostRequest;
import com.hakanozdabak.BlogApp.business.responses.PostResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class PostController {

    private final PostService postService;

    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostResponse>> getAllPosts(){
        return ResponseEntity.ok(this.postService.getAllPosts());
    }

    @PostMapping("/addPost")
    public void add(@RequestBody PostRequest postRequest){
        this.postService.add(postRequest);
    }

    @PutMapping("/updatePost")
    public void update(@RequestBody PostRequest postRequest){
        this.postService.update(postRequest);
    }

    @DeleteMapping("/deletePost/{id}")
    public void delete(@PathVariable int id){
        this.postService.delete(id);
    }

}
