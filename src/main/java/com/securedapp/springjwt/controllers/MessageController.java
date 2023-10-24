package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.models.Message;
import com.securedapp.springjwt.services.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/msg")
public class MessageController {

    @PostMapping("/add")
    public Message create(@RequestBody Message message) {
        return messageServiceImpl.create(message);
    }

    @PutMapping("/edit/{id}")
    public Message update(@RequestBody Message message,@PathVariable Long id) {
        return messageServiceImpl.update(message, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return messageServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public Message getMessage(@PathVariable Long id) {
        return messageServiceImpl.getMessage(id);
    }

    @GetMapping("/all")
    public List<Message> getListMessages() {
        return messageServiceImpl.getListMessages();
    }

    @Autowired
    private MessageServiceImpl messageServiceImpl;
}
