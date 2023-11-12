package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.CommentDto;
import com.securedapp.springjwt.services.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cmt")
public class CommentController {
    @PostMapping("/add")
    public CommentDto create(@RequestBody CommentDto commentDto) {
        return commentServiceImpl.create(commentDto);
    }

    @PutMapping("/edit/{id}")
    public CommentDto update(@RequestBody CommentDto commentDto, @PathVariable Long id) {
        return commentServiceImpl.update(commentDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return commentServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public CommentDto getComment(@PathVariable Long id) {
        return commentServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<CommentDto> getListComments() {
        return commentServiceImpl.getList();
    }

    @Autowired
    private CommentServiceImpl commentServiceImpl;
}
