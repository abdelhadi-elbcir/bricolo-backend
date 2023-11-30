package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.BlogDto;
import com.securedapp.springjwt.dto.CommentDto;
import com.securedapp.springjwt.models.Blog;
import com.securedapp.springjwt.models.Comment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentMapper {

    private boolean user = true;
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

    public CommentDto toDto(Comment comment){
        return new CommentDto(
                comment.getText(),
                user ? userMapper.toDto(comment.getUser()) : null
        );
    }

    public Comment toEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setUser(userMapper.toEntity(commentDto.getUserDto()));
        return comment;
    }

    public List<Comment> toEntity(List<CommentDto> commentDtos){
        return  commentDtos.stream().map(this::toEntity).toList();
    }

    public List<CommentDto> toDto(List<Comment> comments){
        return  comments.stream().map(this::toDto).toList();
    }

}
