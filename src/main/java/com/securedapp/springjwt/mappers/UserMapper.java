package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.UserDto;
import com.securedapp.springjwt.models.*;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return  new UserDto(
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
        user.getBlogList(),
        user.getCommentList(),
        user.getMessageList(),
        user.getRattingList(),
        user.getServicesList()
        );
    }
}
