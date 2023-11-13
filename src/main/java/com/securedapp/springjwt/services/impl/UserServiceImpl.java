package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.UserDto;
import com.securedapp.springjwt.mappers.UserMapper;
import com.securedapp.springjwt.models.User;
import com.securedapp.springjwt.repository.UserRepository;
import com.securedapp.springjwt.services.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto, Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setAbout(userDto.getAbout());
            user.setAddress(userDto.getAddress());
            user.setFacebook(userDto.getFacebook());
            user.setYoutube(user.getYoutube());
            user.setInstagram(userDto.getInstagram());
            user.setLinkedin(userDto.getLinkedin());
            userRepository.save(user);
            return userMapper.toDto(user);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "User deleted !";
    }

    @Override
    public UserDto getItem(Long id) {
        if(userRepository.findById(id).isPresent())
            return  userMapper.toDto(userRepository.findById(id).get());
        return null;
    }

    @Override
    public List<UserDto> getList() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList)
            if(user != null)
                userDtoList.add(userMapper.toDto(user));
        return userDtoList;
    }
}
