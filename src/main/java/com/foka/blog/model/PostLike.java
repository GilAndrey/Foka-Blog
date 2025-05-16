package com.foka.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post_likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Vários Likes podem pertencer a um mesmo post
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // Cada like está relacionado a um usuário
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
