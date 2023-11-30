package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.mappers.ServiceMapper;
import com.securedapp.springjwt.models.Service;
import com.securedapp.springjwt.repository.ServiceRepository;
import com.securedapp.springjwt.services.facade.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public ServiceDto create(ServiceDto serviceDto) {
        return serviceMapper.toDto(
                serviceRepository.save(
                        serviceMapper.toEntity(serviceDto)
                )
        );
    }

    @Override
    public ServiceDto update(ServiceDto serviceDto, Long id) {
        Service service = serviceMapper.toEntity(serviceDto);
        Service serviceFounded = serviceRepository.findById(id).orElse(null);
        if(serviceFounded != null){
            serviceFounded.setCategory(service.getCategory());
            serviceFounded.setCity(service.getCity());
            serviceFounded.setAnnounceList(service.getAnnounceList());
            serviceFounded.setDescription(service.getDescription());
            serviceFounded.setImage(service.getImage());
            serviceFounded.setPhone(service.getPhone());
            serviceFounded.setPrice(service.getPrice());
            serviceFounded.setTitle(service.getTitle());
            serviceFounded.setUser(service.getUser());
            serviceRepository.save(serviceFounded);
            return serviceMapper.toDto(serviceFounded);
        }
        return  null;
    }

    @Override
    public String delete(Long id) {
        if(serviceRepository.findById(id).isPresent()){
            serviceRepository.deleteById(id);
            return "Service deleted !";
        }
        return  "Sevice Doesn't exist !";
    }

    @Override
    public ServiceDto getItem(Long id) {
        if(serviceRepository.findById(id).isPresent())
            return serviceMapper.toDto(serviceRepository.findById(id).get());
        return  null;
    }

    @Override
    public List<ServiceDto> getList() {
        serviceMapper.getCityMapper().setService(false);
        serviceMapper.getUserMapper().setService(false);
        serviceMapper.getCategoryMapper().setService(false);
        List<ServiceDto> serviceDtoList = serviceMapper.toDto(serviceRepository.findAll());
        serviceMapper.getCityMapper().setService(true);
        serviceMapper.getUserMapper().setService(true);
        serviceMapper.getCategoryMapper().setService(true);
        return serviceDtoList;
    }
}
