package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.CityDto;
import com.securedapp.springjwt.mappers.CityMapper;
import com.securedapp.springjwt.models.City;
import com.securedapp.springjwt.repository.CityRepository;
import com.securedapp.springjwt.services.facade.CitySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CitySevice {

    @Autowired
    private  CityRepository cityRepository;

    @Autowired
    private CityMapper cityMapper;

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
        return null;
    }

    @Override
    public String delete(Long id) {
        cityRepository.deleteById(id);
        return "done";
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
        List<City> cityList = cityRepository.findAll();
        List<CityDto> cityDtoList = new ArrayList<>();
        for (City city:
             cityList) {
            if(city != null)
              cityDtoList.add(cityMapper.toDto(city));
        }
        return  cityDtoList;
    }
}
