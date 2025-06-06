package com.foka.blog.repository;

import com.foka.blog.model.Post;
import com.foka.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // Método para encontrar posts por autor
    List<Post> findByAuthor(User author);
}
