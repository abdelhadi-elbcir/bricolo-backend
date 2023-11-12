package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.models.User;
import com.securedapp.springjwt.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserConrtoller {

    @Autowired
    private UserServiceImpl userServiceImpl ;

    @PutMapping("/edit/{id}")
    public User update(@RequestBody User user, @PathVariable  Long id) {
        return userServiceImpl.update(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        return userServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<User> getListUsers() {
        return userServiceImpl.getList();
    }
}
