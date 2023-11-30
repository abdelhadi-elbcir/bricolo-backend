package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.dto.CityDto;
import com.securedapp.springjwt.models.Category;
import com.securedapp.springjwt.models.City;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CityMapper {

    private boolean service = true;
    @Autowired
    private ServiceMapper serviceMapper;

    public boolean isService() {
        return service;
    }

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }

    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    public void setService(boolean service) {
        this.service = service;
    }

    public CityDto toDto(City city){
        return new CityDto(
                city.getId(),
                city.getName(),
                service?serviceMapper.toDto(city.getServiceList()):null
        );
    }

    public City toEntity(CityDto cityDto){
        City city = new City();
        city.setName(cityDto.getName());
        city.setServiceList(serviceMapper.toEntity(cityDto.getServiceList()));
        return city;
    }

    public List<City> toEntity(List<CityDto> cityDtos){
        return  cityDtos.stream().map(this::toEntity).toList();
    }

    public List<CityDto> toDto(List<City> cities){
        return  cities.stream().map(this::toDto).toList();
    }
    
}
