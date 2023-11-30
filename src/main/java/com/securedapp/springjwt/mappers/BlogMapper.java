package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.BlogDto;
import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.models.Blog;
import com.securedapp.springjwt.models.Service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogMapper {

    private boolean user;
    @Autowired
    private UserMapper userMapper;

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public BlogDto toDto(Blog blog){
        return  new BlogDto(
                blog.getTitle(),
                blog.getBody(),
                blog.getImage(),
                user ? userMapper.toDto(blog.getUser()) : null
                );
    }

    public Blog toEntity(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setBody(blogDto.getBody());
        blog.setImage(blogDto.getImage());
        blog.setUser(userMapper.toEntity(blogDto.getUserDto()));
        return  blog;
    }

    public List<Blog> toEntity(List<BlogDto> blogDtos){
        return  blogDtos.stream().map(this::toEntity).toList();
    }

    public List<BlogDto> toDto(List<Blog> blogs){
        return  blogs.stream().map(this::toDto).toList();
    }

}
