package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.models.Blog;
import com.securedapp.springjwt.repository.BlogRepository;
import com.securedapp.springjwt.services.facade.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public Blog create(Blog blog) {
       return blogRepository.save(blog);
    }

    @Override
    public Blog update(Blog blog, Long id) {
       Blog blogToUpdate =  blogRepository.findById(id).orElse(null);
       if(blogToUpdate != null){
           blogToUpdate.setBody(blog.getBody());
           blogToUpdate.setImage(blog.getImage());
           blogToUpdate.setTitle(blog.getTitle());
           blogRepository.save(blogToUpdate);
           return  blogToUpdate;
       }
       return null;
    }

    @Override
    public String delete(Long id) {
        Blog blogToDelete = blogRepository.findById(id).orElse(null);
        if(blogToDelete != null) {
            blogRepository.deleteById(blogToDelete.getId());
            return "Blog delete!";
        }
        return "Blog doesn't exist!";
    }

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> getListBlogs() {
        return blogRepository.findAll();
    }
}
