package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.models.User;
import com.securedapp.springjwt.repository.UserRepository;
import com.securedapp.springjwt.services.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user, Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return  "user deleted!";
    }

    @Override
    public User getItem(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }
}
