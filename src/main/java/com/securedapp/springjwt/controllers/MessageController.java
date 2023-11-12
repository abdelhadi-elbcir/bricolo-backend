package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.MessageDto;
import com.securedapp.springjwt.services.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/msg")
public class MessageController {

    @PostMapping("/add")
    public MessageDto create(@RequestBody MessageDto messageDto) {
        return messageServiceImpl.create(messageDto);
    }

    @PutMapping("/edit/{id}")
    public MessageDto update(@RequestBody MessageDto messageDto,@PathVariable Long id) {
        return messageServiceImpl.update(messageDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return messageServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public MessageDto getMessage(@PathVariable Long id) {
        return messageServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<MessageDto> getListMessages() {
        return messageServiceImpl.getList();
    }

    @Autowired
    private MessageServiceImpl messageServiceImpl;
}
