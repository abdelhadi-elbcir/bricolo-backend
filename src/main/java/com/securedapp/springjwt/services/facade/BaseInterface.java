package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.Blog;

import java.util.List;

public interface BaseInterface<T>{
    T create(T t);
    T update(T t, Long id);
    String delete(Long id);
    T getItem(Long id);
    List<T> getList();
}
