package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.AnnounceDto;
import com.securedapp.springjwt.models.Announce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnnounceMapper {

    private boolean service = true;
    private boolean category = true;
    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    public boolean isService() {
        return service;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    public boolean isCategory() {
        return category;
    }

    public void setCategory(boolean category) {
        this.category = category;
    }

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }

    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public CategoryMapper getCategoryMapper() {
        return categoryMapper;
    }

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public AnnounceDto toDto(Announce announce){
        return  new AnnounceDto(
                announce.getTitle(),
                announce.getBody(),
                announce.getImage(),
                service ? serviceMapper.toDto(announce.getService()) : null,
                category ? categoryMapper.toDto(announce.getCategory()) : null
        );
    }

    public Announce toEntity(AnnounceDto announceDto){
        Announce announce = new Announce();
        announce.setTitle(announceDto.getTitle());
        announce.setBody(announceDto.getBody());
        announce.setImage(announceDto.getImage());
        announce.setCategory(categoryMapper.toEntity(announceDto.getCategoryDto()));
        announce.setService(serviceMapper.toEntity(announceDto.getServiceDto()));
        return announce;
    }

    public List<Announce> toEntity(List<AnnounceDto> announceDtos){
        return  announceDtos.stream().map(this::toEntity).toList();
    }

    public List<AnnounceDto> toDto(List<Announce> announces){
        return  announces.stream().map(this::toDto).toList();
    }


}
