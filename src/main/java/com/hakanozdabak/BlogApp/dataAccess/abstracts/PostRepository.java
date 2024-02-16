package com.hakanozdabak.BlogApp.dataAccess.abstracts;

import com.hakanozdabak.BlogApp.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
