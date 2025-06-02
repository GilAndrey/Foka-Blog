package com.foka.blog.repository;

import com.foka.blog.model.Post;
import com.foka.blog.model.Tag;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Entity
public interface TagRepository extends JpaRepository<Tag, Long> {

    // Método para encontrar tags por nome
    Optional<Tag> findByName(String name);

}
