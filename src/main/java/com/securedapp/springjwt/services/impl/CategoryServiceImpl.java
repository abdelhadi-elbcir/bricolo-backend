package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.mappers.CategoryMapper;
import com.securedapp.springjwt.models.Category;
import com.securedapp.springjwt.repository.CategoryRepository;
import com.securedapp.springjwt.services.facade.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryFounded = categoryRepository.findById(id).orElse(null);
        if(categoryFounded != null){
            categoryFounded.setName(category.getName());
            categoryFounded.setServiceList(category.getServiceList());
            categoryFounded.setAnnounceList(category.getAnnounceList());
            categoryRepository.save(categoryFounded);
            return  categoryMapper.toDto(categoryFounded);
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
        categoryMapper.getServiceMapper().setCategory(false);
        List<CategoryDto> categoryDtoList = categoryMapper.toDto(categoryRepository.findAll());
        categoryMapper.getServiceMapper().setCategory(true);
        return  categoryDtoList;
    }
}
