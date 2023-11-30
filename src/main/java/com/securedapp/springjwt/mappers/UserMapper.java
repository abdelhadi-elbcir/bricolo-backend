package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.UserDto;
import com.securedapp.springjwt.models.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    private boolean service = true;
    private boolean blog = true;
    private boolean message = true;
    private boolean ratting = true;
    private boolean comment = true;

    public boolean isService() {
        return service;
    }

    public boolean isBlog() {
        return blog;
    }

    public void setBlog(boolean blog) {
        this.blog = blog;
    }

    public boolean isMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }

    public boolean isRatting() {
        return ratting;
    }

    public void setRatting(boolean ratting) {
        this.ratting = ratting;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }

    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public BlogMapper getBlogMapper() {
        return blogMapper;
    }

    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    public MessageMapper getMessageMapper() {
        return messageMapper;
    }

    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public RattingMapper getRattingMapper() {
        return rattingMapper;
    }

    public void setRattingMapper(RattingMapper rattingMapper) {
        this.rattingMapper = rattingMapper;
    }

    public CommentMapper getCommentMapper() {
        return commentMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private RattingMapper rattingMapper;
    @Autowired
    private CommentMapper commentMapper;


    public void setService(boolean service) {
        this.service = service;
    }


    public UserDto toDto(User user) {
        return new UserDto(
                user.getPhone(),
                user.getAddress(),
                user.getAbout(),
                user.getLinkedin(),
                user.getInstagram(),
                user.getYoutube(),
                user.getFacebook(),
                user.getImage(),
                user.getFirstname(),
                user.getLastname(),
                blog ? blogMapper.toDto(user.getBlogList()) : null,
                comment ? commentMapper.toDto(user.getCommentList()) : null,
                message ? messageMapper.toDto(user.getMessageList()) : null,
                ratting ? rattingMapper.toDto(user.getRattingList()) : null,
                service ? serviceMapper.toDto(user.getServicesList()) : null
        );
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
        user.setAbout(userDto.getAbout());
        user.setLinkedin(userDto.getLinkedin());
        user.setInstagram(userDto.getInstagram());
        user.setYoutube(userDto.getYoutube());
        user.setFacebook(userDto.getFacebook());
        user.setImage(userDto.getImage());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setBlogList(blogMapper.toEntity(userDto.getBlogList()));
        user.setCommentList(commentMapper.toEntity(userDto.getCommentList()));
        user.setMessageList(messageMapper.toEntity(userDto.getMessageList()));
        user.setRattingList(rattingMapper.toEntity(userDto.getRattingList()));
        user.setServicesList(serviceMapper.toEntity(userDto.getServicesList()));
        return user;
    }

    public List<UserDto> toDto(List<User> users){
        return users.stream().map(this::toDto).toList();
    }

    public List<User> toEntity(List<UserDto> userDtos){
        return  userDtos.stream().map(this::toEntity).toList();
    }

}
