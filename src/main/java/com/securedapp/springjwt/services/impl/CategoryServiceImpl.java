package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.mappers.CategoryMapper;
import com.securedapp.springjwt.mappers.ServiceMapper;
import com.securedapp.springjwt.models.Category;
import com.securedapp.springjwt.repository.CategoryRepository;
import com.securedapp.springjwt.repository.ServiceRepository;
import com.securedapp.springjwt.services.facade.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        return  categoryMapper.toDto(categoryRepository.save(
                categoryMapper.toEntity(categoryDto)
        ));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null){
            category.setName(categoryDto.getName());
            category.setServiceList(categoryDto.getServiceList());
            category.setAnnounceList(categoryDto.getAnnounceList());
            categoryRepository.save(category);
            return  categoryMapper.toDto(category);
        }
        return  null;
    }

    @Override
    public String delete(Long id) {
        if(categoryRepository.findById(id).isPresent()){
            categoryRepository.deleteById(id);
            return  "Category deleted !";
        }
        return  "Category not found !";
    }

    @Override
    public CategoryDto getItem(Long id) {
        if(categoryRepository.findById(id).isPresent())
            return  categoryMapper.toDto(categoryRepository.findById(id).get());
        return null;
    }

    @Override
    public List<CategoryDto> getList() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList)
            if(category != null)
                categoryDtoList.add(categoryMapper.toDto(category));
        return  categoryDtoList;
    }
}
