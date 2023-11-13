package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.CityDto;
import com.securedapp.springjwt.models.City;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class CityMapper {

    public CityDto toDto(City city){
        return new CityDto(
                city.getId(),
                city.getName(),
                city.getServiceList()
        );
    }

    public City toEntity(CityDto cityDto){
        City city = new City();
        city.setName(cityDto.getName());
        city.setServiceList(cityDto.getServiceList());
        return city;
    }
}
