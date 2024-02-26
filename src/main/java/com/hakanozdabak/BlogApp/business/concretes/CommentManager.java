package com.hakanozdabak.BlogApp.business.concretes;

import com.hakanozdabak.BlogApp.business.abstracts.CommentService;
import com.hakanozdabak.BlogApp.business.core.utilities.mappers.ModelMapperService;
import com.hakanozdabak.BlogApp.business.requests.CommentRequest;
import com.hakanozdabak.BlogApp.business.requests.PostRequest;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.CommentRepository;
import com.hakanozdabak.BlogApp.dataAccess.abstracts.PostRepository;
import com.hakanozdabak.BlogApp.entities.concretes.Comment;
import com.hakanozdabak.BlogApp.entities.concretes.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {
    private final CommentRepository commentRepository;

    private final ModelMapperService modelMapperService;
    @Override
    public void add(CommentRequest commentRequest) {
        Comment comment = this.modelMapperService.forRequest().map(commentRequest, Comment.class);

        this.commentRepository.save(comment);

    }
}
