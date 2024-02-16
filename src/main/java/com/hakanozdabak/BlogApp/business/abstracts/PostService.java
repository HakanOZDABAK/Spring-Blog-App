package com.hakanozdabak.BlogApp.business.abstracts;

import com.hakanozdabak.BlogApp.business.requests.PostRequest;
import com.hakanozdabak.BlogApp.business.responses.PostResponse;
import com.hakanozdabak.BlogApp.entities.concretes.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    void add(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    void update(PostRequest postRequest);

    void delete(int id);

    Optional<PostResponse> getPost(int id);

}
