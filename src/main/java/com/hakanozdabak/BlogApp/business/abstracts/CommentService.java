package com.hakanozdabak.BlogApp.business.abstracts;

import com.hakanozdabak.BlogApp.business.requests.CommentRequest;
import com.hakanozdabak.BlogApp.business.requests.PostRequest;
import com.hakanozdabak.BlogApp.entities.concretes.Comment;

public interface CommentService {

    void add(CommentRequest commentRequest);
}
