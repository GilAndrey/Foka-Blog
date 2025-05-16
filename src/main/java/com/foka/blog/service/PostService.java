package com.foka.blog.service;

import com.foka.blog.model.Post;
import com.foka.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Lista todos os posts do db
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Criar um novo post com Data setada
    public Post createPost(Post post) {
        post.setCreateAt(LocalDateTime.now());
        return postRepository.save(post);
    }
}
