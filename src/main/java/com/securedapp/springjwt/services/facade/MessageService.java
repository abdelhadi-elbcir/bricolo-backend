package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.Message;

import java.util.List;

public interface MessageService {
    Message create(Message message);
    Message update(Message message, Long id);
    String delete(Long id);
    Message getMessage(Long id);
    List<Message> getListMessages();
}