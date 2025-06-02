package com.foka.blog.service;

import com.foka.blog.model.Post;
import com.foka.blog.model.PostLike;
import com.foka.blog.model.User;
import com.foka.blog.repository.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostLikeService {

    @Autowired
    private PostLikeRepository postLikeRepository;

    // Curtir post / Verificar se já não possui like.
    public void likePost(Post post, User user) {
        Optional<PostLike> existingLike = postLikeRepository.findByPostAndUser(post.getId(), user.getId());
        if (existingLike.isEmpty()) {
            PostLike like = new PostLike();
           like.setPost(post);
           like.setUser(user);
           postLikeRepository.save(like);

        }
    }

    // Contar curtidas
    public Long countLikes(Post post) {
        return postLikeRepository.countByPost(post.getId());
    }


}
