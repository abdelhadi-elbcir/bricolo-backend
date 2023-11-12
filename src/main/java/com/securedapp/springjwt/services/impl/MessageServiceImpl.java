package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.MessageDto;
import com.securedapp.springjwt.mappers.MessageMapper;
import com.securedapp.springjwt.models.Message;
import com.securedapp.springjwt.repository.MessageRepository;
import com.securedapp.springjwt.services.facade.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public MessageDto create(MessageDto messageDto) {
        return messageMapper.toDto(
                messageRepository.save(
                        messageMapper.toEntity(messageDto)
                )
        );
    }

    @Override
    public MessageDto update(MessageDto messageDto, Long id) {
        Message messageToUpdate = messageRepository.findById(id).orElse(null);
        if(messageToUpdate != null){
            messageToUpdate.setText(messageDto.getText());
            return  messageMapper.toDto(messageToUpdate);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Message messageToDelete= messageRepository.findById(id).orElse(null);
        if(messageToDelete != null){
            messageRepository.deleteById(messageToDelete.getId());
            return  "MessageDto deleted !";
        }
        return "MessageDto doesn't exist !";
    }

    @Override
    public MessageDto getItem(Long id) {
        if(messageRepository.findById(id).isPresent())
           return messageMapper.toDto(messageRepository.findById(id).get());
        return  null;
    }

    @Override
    public List<MessageDto> getList() {
        List<Message> messageList = messageRepository.findAll();
        List<MessageDto> messageDtoList = new ArrayList<>();
        for (Message message : messageList)
            if(message!=null)
                messageDtoList.add(messageMapper.toDto(message));
        return messageDtoList;
    }
}
