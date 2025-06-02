package com.foka.blog.service;

import com.foka.blog.model.Post;
import com.foka.blog.model.User;
import com.foka.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    // Buscar Posts por ID
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // Buscar posts de um autor especifico
    public List<Post> getPostsByAutor(User author) {
        return postRepository.findByAuthor(author);
    }

    // Atualizar um post
    public Post updatePost(Long id, Post post) {
        return postRepository.save(post);
    }

    // Deletar um Post
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }


}
