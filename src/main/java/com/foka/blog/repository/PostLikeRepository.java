package com.foka.blog.repository;

import com.foka.blog.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    // Método para encontrar um PostLike por post e usuário
    Optional<PostLike> findByPostAndUser(Long post, Long user);

    // Método para contar o número de likes de um post
    long countByPost(Long post);
}
