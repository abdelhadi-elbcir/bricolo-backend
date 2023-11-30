package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.MessageDto;
import com.securedapp.springjwt.dto.RattingDto;
import com.securedapp.springjwt.models.Message;
import com.securedapp.springjwt.models.Ratting;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RattingMapper {

    private boolean user = true;
    @Autowired
    private UserMapper userMapper;
    public RattingDto toDto(Ratting ratting){
        return  new RattingDto(
                ratting.getStars(),
                user ? userMapper.toDto(ratting.getUser()) : null
        );
    }

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

    public Ratting toEntity(RattingDto rattingDto){
        Ratting ratting = new Ratting();
        ratting.setStars(rattingDto.getStars());
        ratting.setUser(userMapper.toEntity(rattingDto.getUserDto()));
        return  ratting;
    }

    public List<Ratting> toEntity(List<RattingDto> rattingDtos){
        return  rattingDtos.stream().map(this::toEntity).toList();
    }

    public List<RattingDto> toDto(List<Ratting> rattings){
        return  rattings.stream().map(this::toDto).toList();
    }
}
