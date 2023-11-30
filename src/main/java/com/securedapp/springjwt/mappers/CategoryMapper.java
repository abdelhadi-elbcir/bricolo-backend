package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.BlogDto;
import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.models.Blog;
import com.securedapp.springjwt.models.Category;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    private boolean service = true;
    private boolean announce = true;
    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private AnnounceMapper announceMapper;

    public boolean isService() {
        return service;
    }

    public boolean isAnnounce() {
        return announce;
    }

    public void setAnnounce(boolean announce) {
        this.announce = announce;
    }

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }

    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public AnnounceMapper getAnnounceMapper() {
        return announceMapper;
    }

    public void setAnnounceMapper(AnnounceMapper announceMapper) {
        this.announceMapper = announceMapper;
    }

    public void setService(boolean service) {
        this.service = service;
    }


    public CategoryDto toDto(Category category){
        return  new CategoryDto(
                category.getId(),
                category.getName(),
                service ? serviceMapper.toDto(category.getServiceList()) : null,
                announce ? announceMapper.toDto(category.getAnnounceList()) : null
        );
    }

    public Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setServiceList(serviceMapper.toEntity(categoryDto.getServiceList()));
        category.setAnnounceList(null);
        return  category;
    }

    public List<Category> toEntity(List<CategoryDto> categoryDtos){
        return  categoryDtos.stream().map(this::toEntity).toList();
    }

    public List<CategoryDto> toDto(List<Category> categories){
        return  categories.stream().map(this::toDto).toList();
    }

}
