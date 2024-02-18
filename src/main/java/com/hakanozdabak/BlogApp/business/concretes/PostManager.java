package com.hakanozdabak.BlogApp.business.concretes;

import com.hakanozdabak.BlogApp.business.abstracts.PostService;
import com.hakanozdabak.BlogApp.business.core.utilities.mappers.ModelMapperService;
import com.hakanozdabak.BlogApp.business.requests.PostRequest;
import com.hakanozdabak.BlogApp.business.responses.PostResponse;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.PostRepository;
import com.hakanozdabak.BlogApp.entities.concretes.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

    private final PostRepository postRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public void add(PostRequest postRequest) {
     Post post = this.modelMapperService.forRequest().map(postRequest,Post.class);

     this.postRepository.save(post);

    }

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses= posts.stream()
                .map(post -> this.modelMapperService.forResponse().map(post, PostResponse.class)).collect(Collectors.toList());
        return postResponses;
    }

    @Override
    public void update(PostRequest postRequest) {
        Post post = this.modelMapperService.forRequest().map(postRequest,Post.class);
        this.postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        this.postRepository.deleteById(id);
    }

    @Override
    public Optional<PostResponse> getPostById(int id) {
        return this.postRepository.findById(id)
                .map(post -> this.modelMapperService.forResponse().map(post, PostResponse.class));
    }
}
