package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.MessageDto;
import com.securedapp.springjwt.models.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDto toDto(Message message){
        return  new MessageDto(
                message.getText(),
                message.getUser()
        );
    }

    public Message toEntity(MessageDto messageDto){
        Message message = new Message();
        message.setText(messageDto.getText());
        message.setUser(messageDto.getUser());
        return message;
    }

}
