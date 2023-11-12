package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.MessageDto;
import com.securedapp.springjwt.repository.MessageRepository;
import com.securedapp.springjwt.services.facade.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository MessageRepository;

    @Override
    public MessageDto create(MessageDto messageDto) {
        return MessageRepository.save(messageDto);
    }

    @Override
    public MessageDto update(MessageDto messageDto, Long id) {
        MessageDto MessageToUpdate = MessageRepository.findById(id).orElse(null);
        if(MessageToUpdate != null){
            MessageToUpdate.setText(messageDto.getText());
            return  MessageToUpdate;
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        MessageDto messageToDelete= MessageRepository.findById(id).orElse(null);
        if(messageToDelete != null){
            MessageRepository.deleteById(messageToDelete.getId());
            return  "MessageDto deleted !";
        }
        return "MessageDto doesn't exist !";
    }

    @Override
    public MessageDto getItem(Long id) {
        return MessageRepository.findById(id).orElse(null);
    }

    @Override
    public List<MessageDto> getList() {
        return MessageRepository.findAll();
    }
}
