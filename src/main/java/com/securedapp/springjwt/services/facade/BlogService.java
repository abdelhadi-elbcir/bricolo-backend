package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.Blog;

import java.util.List;

public interface BlogService {
    Blog create(Blog blog);
    Blog update(Blog blog, Long id);
    String delete(Long id);
    Blog getBlog(Long id);
    List<Blog> getListBlogs();
}
