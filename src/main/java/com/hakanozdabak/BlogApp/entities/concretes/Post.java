package com.hakanozdabak.BlogApp.entities.concretes;

import com.hakanozdabak.BlogApp.business.responses.UserResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
@Entity
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String postName;
    @Column(name = "postDetail")
    private String postDetail;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
