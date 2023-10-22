package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.Comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment comment);
    Comment update(Comment comment, Long id);
    String delete(Long id);
    Comment getComment(Long id);
    List<Comment> getListComments();
}
