package com.foka.blog.repository;

import com.foka.blog.model.Comment;
import com.foka.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    Optional<Comment> findByPostId(Long id);
}

