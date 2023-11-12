package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.UserDto;
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
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public UserDto getItem(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getList() {
        return null;
    }
}
