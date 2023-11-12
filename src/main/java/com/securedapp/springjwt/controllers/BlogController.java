package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.BlogDto;
import com.securedapp.springjwt.services.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
    @Autowired
    private BlogServiceImpl blogServiceImpl;

    @PostMapping("/add")
    public BlogDto create(@RequestBody BlogDto blogDto) {
        return blogServiceImpl.create(blogDto);
    }

    @PutMapping("/edit/{id}")
    public BlogDto update(@RequestBody BlogDto blogDto,@PathVariable Long id) {
        return blogServiceImpl.update(blogDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return blogServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public BlogDto getBlog(@PathVariable Long id) {
        return blogServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<BlogDto> getListBlogs() {
        return blogServiceImpl.getList();
    }

}
