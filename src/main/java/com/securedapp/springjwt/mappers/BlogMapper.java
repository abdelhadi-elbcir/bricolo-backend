package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.BlogDto;
import com.securedapp.springjwt.models.Blog;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    public BlogDto toDto(Blog blog){
        return  new BlogDto(
                blog.getTitle(),
                blog.getBody(),
                blog.getImage(),
                blog.getUser()
                );
    }

    public Blog toEntity(BlogDto blogDto) {
        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setBody(blogDto.getBody());
        blog.setImage(blogDto.getImage());
        blogDto.setUser(blogDto.getUser());
        return  blog;
    }

}
