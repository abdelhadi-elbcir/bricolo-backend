package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.CommentDto;
import com.securedapp.springjwt.models.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentDto toDto(Comment comment){
        return new CommentDto(
                comment.getText(),
                comment.getUser()
        );
    }

    public Comment toEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setUser(commentDto.getUser());
        return comment;
    }

}
