package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.models.Service;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceMapper {

    private boolean city = true;
    private boolean user = true ;
    private boolean category = true ;
    private boolean announce = true ;

    public boolean isCity() {
        return city;
    }

    public boolean isUser() {
        return user;
    }

    public boolean isCategory() {
        return category;
    }

    public boolean isAnnounce() {
        return announce;
    }

    public void setAnnounce(boolean announce) {
        this.announce = announce;
    }

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public void setCityMapper(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public AnnounceMapper getAnnounceMapper() {
        return announceMapper;
    }

    public void setAnnounceMapper(AnnounceMapper announceMapper) {
        this.announceMapper = announceMapper;
    }

    public void setCity(boolean city) {
        this.city = city;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public void setCategory(boolean category) {
        this.category = category;
    }

    public ServiceDto toDto(Service service){
        return  new ServiceDto(
                service.getTitle(),
                service.getPrice(),
                service.getDescription(),
                service.getImage(),
                service.getPhone(),
                announce ? announceMapper.toDto(service.getAnnounceList()) : null,
                city ? cityMapper.toDto(service.getCity()):null,
                category ? categoryMapper.toDto(service.getCategory()):null,
                user ? userMapper.toDto(service.getUser()) : null
        );
    }

    public List<ServiceDto> toDto(List<Service> services){
        return services.stream().map(this::toDto).toList();
    }

    public List<Service> toEntity(List<ServiceDto> serviceDtos){
        return  serviceDtos.stream().map(this::toEntity).toList();
    }

    public Service toEntity(ServiceDto serviceDto){
        Service service = new Service();
        service.setCategory(categoryMapper.toEntity(serviceDto.getCategoryDto()));
        service.setCity(cityMapper.toEntity(serviceDto.getCityDto()));
        service.setAnnounceList(announceMapper.toEntity(serviceDto.getAnnounceList()));
        service.setDescription(serviceDto.getDescription());
        service.setImage(serviceDto.getImage());
        service.setPhone(serviceDto.getPhone());
        service.setPrice(serviceDto.getPrice());
        service.setTitle(serviceDto.getTitle());
        service.setUser(userMapper.toEntity(serviceDto.getUserDto()));
        return  service;
    }

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AnnounceMapper announceMapper;


    public CategoryMapper getCategoryMapper() {
        return categoryMapper;
    }

    public CityMapper getCityMapper() {
        return cityMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }
}
