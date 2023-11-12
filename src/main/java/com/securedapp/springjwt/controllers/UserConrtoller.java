package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.UserDto;
import com.securedapp.springjwt.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userDto")
public class UserConrtoller {

    @Autowired
    private UserServiceImpl userServiceImpl ;

    @PutMapping("/edit/{id}")
    public UserDto update(@RequestBody UserDto userDto, @PathVariable  Long id) {
        return userServiceImpl.update(userDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<UserDto> getListUsers() {
        return userServiceImpl.getList();
    }
}
