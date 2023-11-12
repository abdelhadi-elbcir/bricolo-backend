package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.services.facade.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
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
