package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CommentDto;
import com.securedapp.springjwt.mappers.CommentMapper;
import com.securedapp.springjwt.models.Comment;
import com.securedapp.springjwt.repository.CommentRepository;
import com.securedapp.springjwt.services.facade.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public CommentDto create(CommentDto commentDto) {
        return commentMapper.toDto(
                commentRepository.save(
                      commentMapper.toEntity(commentDto)
                )
        );
    }

    @Override
    public CommentDto update(CommentDto commentDto, Long id) {
        Comment commentToUpdate = commentRepository.findById(id).orElse(null);
        Comment newComment = commentMapper.toEntity(commentDto);
        if(commentToUpdate != null){
            commentToUpdate.setText(newComment.getText());
            return  commentMapper.toDto(commentToUpdate);
        }
        return  null;
    }

    @Override
    public String delete(Long id) {
        Comment commentToDelete = commentRepository.findById(id).orElse(null);
        if(commentToDelete != null){
            commentRepository.deleteById(commentToDelete.getId());
            return  "CommentDto deleted !";
        }
        return  "CommentDto doesn't exist !";
    }

    @Override
    public CommentDto getItem(Long id) {
        if(commentRepository.findById(id).isPresent())
           return commentMapper.toDto(commentRepository.findById(id).get());
        return  null;
    }

    @Override
    public List<CommentDto> getList() {
        List<Comment> commentList = commentRepository.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentList)
            if(comment != null)
                commentDtoList.add(commentMapper.toDto(comment));
        return commentDtoList;
    }
}
