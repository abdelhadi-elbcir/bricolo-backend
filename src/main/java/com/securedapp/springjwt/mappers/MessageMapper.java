package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.MessageDto;
import com.securedapp.springjwt.models.Message;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageMapper {

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

    public MessageDto toDto(Message message){
        return  new MessageDto(
                message.getText(),
                user ? userMapper.toDto(message.getUser()) : null
        );
    }

    public Message toEntity(MessageDto messageDto){
        Message message = new Message();
        message.setText(messageDto.getText());
        message.setUser(userMapper.toEntity(messageDto.getUserDto()));
        return message;
    }

    public List<Message> toEntity(List<MessageDto> messageDtos){
        return  messageDtos.stream().map(this::toEntity).toList();
    }

    public List<MessageDto> toDto(List<Message> messages){
        return  messages.stream().map(this::toDto).toList();
    }

}
