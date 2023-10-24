package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.models.Message;
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
    public Message create(Message message) {
        return MessageRepository.save(message);
    }

    @Override
    public Message update(Message message, Long id) {
        Message MessageToUpdate = MessageRepository.findById(id).orElse(null);
        if(MessageToUpdate != null){
            MessageToUpdate.setText(message.getText());
            return  MessageToUpdate;
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Message messageToDelete= MessageRepository.findById(id).orElse(null);
        if(messageToDelete != null){
            MessageRepository.deleteById(messageToDelete.getId());
            return  "Message deleted !";
        }
        return "Message doesn't exist !";
    }

    @Override
    public Message getMessage(Long id) {
        return MessageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> getListMessages() {
        return MessageRepository.findAll();
    }
}
