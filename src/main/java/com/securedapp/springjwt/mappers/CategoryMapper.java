package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto toDto(Category category){
        return  new CategoryDto(
                category.getId(),
                category.getName(),
                category.getServiceList(),
                category.getAnnounceList()
        );
    }

    public Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setServiceList(categoryDto.getServiceList());
        category.setAnnounceList(categoryDto.getAnnounceList());
        return  category;
    }
}
