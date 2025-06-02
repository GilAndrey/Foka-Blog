package com.foka.blog.service;

import com.foka.blog.model.Comment;
import com.foka.blog.model.Post;
import com.foka.blog.model.User;
import com.foka.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Criar comentario -> Passando tudo que é necessario para um comentario
//    public Comment createComment(String content, Post post, User user) {
//        Comment comment = new Comment();
//        comment.setComment(content);
//        comment.setPostId(post);
//        comment.setUserId(user);
//        comment.setTimestamp(LocalDateTime.now());
//        return commentRepository.save(comment);
//    }

    public Comment createComment(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    // Atualizar Comentario
    public Comment updateComment(Long id, Comment updateComment) {
        return commentRepository.findById(id).map(comment -> {
            comment.setComment(updateComment.getComment());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new RuntimeException("Comment not Found"));
    }


    // Buscar todos os comentarios
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

   // Buscar comentario de um post
    public List<Comment> getCommentsByPost(Post post){
        return commentRepository.findByPost(post);
    }

    // Buscar comentario de um post
    public Optional<Comment> getCommentsByPostId(Long id){
        return commentRepository.findByPostId(id);
    }

    // Buscar comentario por Id
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findByPostId(id);
    }

    // Deletar um comentario
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }


}
