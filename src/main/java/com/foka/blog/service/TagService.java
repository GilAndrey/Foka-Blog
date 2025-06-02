package com.foka.blog.service;

import com.foka.blog.model.Tag;
import com.foka.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    // Criar ou encontrar tag Existente
    public Tag getOrCreateTag(String name) {
        Optional<Tag> tagOptional = tagRepository.findByName(name);
        return tagOptional.orElseGet(() -> tagRepository.save(new Tag(name)));
    }


}

