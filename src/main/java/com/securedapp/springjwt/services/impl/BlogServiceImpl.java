package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.mappers.BlogMapper;
import com.securedapp.springjwt.dto.BlogDto;
import com.securedapp.springjwt.models.Blog;
import com.securedapp.springjwt.repository.BlogRepository;
import com.securedapp.springjwt.services.facade.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public BlogDto create(BlogDto blogDto) {
       return blogMapper.toDto(
               blogRepository.save(
                       blogMapper.toEntity(blogDto)
               )
       );
    }

    @Override
    public BlogDto update(BlogDto blogDto, Long id) {
       Blog blog = blogMapper.toEntity(blogDto);
       Blog blogToUpdate =  blogRepository.findById(id).orElse(null);
       if(blogToUpdate != null){
           blogToUpdate.setBody(blog.getBody());
           blogToUpdate.setImage(blog.getImage());
           blogToUpdate.setTitle(blog.getTitle());
           blogRepository.save(blogToUpdate);
           return  blogMapper.toDto(blogToUpdate);
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
    public BlogDto getItem(Long id) {
        if(blogRepository.findById(id).isPresent())
           return  blogMapper.toDto(blogRepository.findById(id).get());
        return  null;
    }

    @Override
    public List<BlogDto> getList() {
        blogMapper.getUserMapper().setBlog(false);
        List<BlogDto> blogDtoList = blogMapper.toDto(blogRepository.findAll());
        blogMapper.getUserMapper().setBlog(true);
        return blogDtoList;
    }
}
