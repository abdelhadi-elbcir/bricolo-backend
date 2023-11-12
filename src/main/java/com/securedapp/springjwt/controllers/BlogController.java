package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.models.Blog;
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
    public Blog create(@RequestBody Blog blog) {
        return blogServiceImpl.create(blog);
    }

    @PutMapping("/edit/{id}")
    public Blog update(@RequestBody Blog blog,@PathVariable Long id) {
        return blogServiceImpl.update(blog, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return blogServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<Blog> getListBlogs() {
        return blogServiceImpl.getList();
    }

}
