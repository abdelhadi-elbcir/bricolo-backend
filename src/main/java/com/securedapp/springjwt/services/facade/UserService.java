package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user, Long id);
    String delete(Long id);
    User getUser(Long id);
    List<User> getListUsers();
}