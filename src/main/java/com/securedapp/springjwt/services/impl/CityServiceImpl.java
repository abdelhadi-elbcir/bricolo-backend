package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CityDto;
import com.securedapp.springjwt.mappers.CityMapper;
import com.securedapp.springjwt.mappers.ServiceMapper;
import com.securedapp.springjwt.models.City;
import com.securedapp.springjwt.repository.CityRepository;
import com.securedapp.springjwt.services.facade.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private  CityRepository cityRepository;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public CityDto create(CityDto cityDto) {
        if(cityDto != null){
            return cityMapper.
                    toDto(cityRepository.save(cityMapper.toEntity(cityDto)));
        }
        return null;
    }

    @Override
    public CityDto update(CityDto cityDto, Long id) {
        City city = cityMapper.toEntity(cityDto);
        City cityFounded = cityRepository.findById(id).orElse(null);
        if(cityFounded != null){
            cityFounded.setName(city.getName());
            cityFounded.setServiceList(city.getServiceList());
            cityRepository.save(cityFounded);
            return  cityMapper.toDto(cityFounded);
        }
        return  null;
    }

    @Override
    public String delete(Long id) {
        if(cityRepository.findById(id).isPresent()){
            cityRepository.deleteById(id);
            return  "City deleted !";
        }
        return "City not found !";
    }

    @Override
    public CityDto getItem(Long id) {
        if(cityRepository.findById(id).isPresent()){
            return  cityMapper.toDto(cityRepository.findById(id).get());
        }
        return  null;
    }

    @Override
    public List<CityDto> getList() {
        cityMapper.getServiceMapper().setCity(false);
        List<CityDto> cityDtoList = cityMapper.toDto(cityRepository.findAll());
        cityMapper.getServiceMapper().setCity(true);
        return  cityDtoList;
    }
}
