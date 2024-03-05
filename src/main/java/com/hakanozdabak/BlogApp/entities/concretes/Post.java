package com.hakanozdabak.BlogApp.entities.concretes;

import com.hakanozdabak.BlogApp.business.responses.UserResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
@Entity
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String postName;
    private String postDetail;



    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;


    @OneToMany(mappedBy = "post")
    private List<Comment> comments;




}
