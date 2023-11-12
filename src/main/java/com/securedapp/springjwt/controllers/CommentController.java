package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.models.Comment;
import com.securedapp.springjwt.services.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cmt")
public class CommentController {
    @PostMapping("/add")
    public Comment create(@RequestBody Comment comment) {
        return commentServiceImpl.create(comment);
    }

    @PutMapping("/edit/{id}")
    public Comment update(@RequestBody Comment comment, @PathVariable Long id) {
        return commentServiceImpl.update(comment, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return commentServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public Comment getComment(@PathVariable Long id) {
        return commentServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<Comment> getListComments() {
        return commentServiceImpl.getList();
    }

    @Autowired
    private CommentServiceImpl commentServiceImpl;
}
