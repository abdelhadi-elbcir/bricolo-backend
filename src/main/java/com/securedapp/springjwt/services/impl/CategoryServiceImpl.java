package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.mappers.ServiceMapper;
import com.securedapp.springjwt.repository.ServiceRepository;
import com.securedapp.springjwt.services.facade.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public CategoryDto getItem(Long id) {
        return null;
    }

    @Override
    public List<CategoryDto> getList() {
        return null;
    }
}
