package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.UserDto;
import com.securedapp.springjwt.mappers.UserMapper;
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
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UserDto userDto, Long id) {
        User user = userMapper.toEntity(userDto);
        User userFounded = userRepository.findById(id).orElse(null);
        if(userFounded != null){
            userFounded.setFirstname(user.getFirstname());
            userFounded.setLastname(user.getLastname());
            userFounded.setAbout(user.getAbout());
            userFounded.setAddress(user.getAddress());
            userFounded.setFacebook(user.getFacebook());
            userFounded.setYoutube(user.getYoutube());
            userFounded.setInstagram(user.getInstagram());
            userFounded.setLinkedin(user.getLinkedin());
            userRepository.save(userFounded);
            return userMapper.toDto(userFounded);
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
        userMapper.getBlogMapper().setUser(false);
        userMapper.getMessageMapper().setUser(false);
        userMapper.getServiceMapper().setUser(false);
        userMapper.getBlogMapper().setUser(false);
        userMapper.getRattingMapper().setUser(false);
        List<UserDto> userDtoList = userMapper.toDto(userRepository.findAll());
        userMapper.getBlogMapper().setUser(true);
        userMapper.getMessageMapper().setUser(true);
        userMapper.getServiceMapper().setUser(true);
        userMapper.getBlogMapper().setUser(true);
        userMapper.getRattingMapper().setUser(true);
        return  userDtoList;
    }

}
