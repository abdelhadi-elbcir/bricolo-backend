package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.models.Comment;
import com.securedapp.springjwt.repository.CommentRepository;
import com.securedapp.springjwt.services.facade.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment, Long id) {
        Comment commentToUpdate = commentRepository.findById(id).orElse(null);
        if(commentToUpdate != null){

            return  commentToUpdate;
        }
        return  null;
    }

    @Override
    public String delete(Long id) {
        Comment commentToDelete = commentRepository.findById(id).orElse(null);
        if(commentToDelete != null){
            commentRepository.deleteById(commentToDelete.getId());
            return  "Comment deleted !";
        }
        return  "Comment doesn't exist !";
    }

    @Override
    public Comment getItem(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getList() {
        return commentRepository.findAll();
    }
}
