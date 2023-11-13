package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.mappers.ServiceMapper;
import com.securedapp.springjwt.models.Service;
import com.securedapp.springjwt.repository.ServiceRepository;
import com.securedapp.springjwt.services.facade.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
        Service service = serviceRepository.findById(id).orElse(null);
        if(service != null){
            service.setCategory(serviceDto.getCategory());
            service.setCity(serviceDto.getCity());
            service.setAnnounceList(serviceDto.getAnnounceList());
            service.setDescription(serviceDto.getDescription());
            service.setImage(serviceDto.getImage());
            service.setPhone(serviceDto.getPhone());
            service.setPrice(serviceDto.getPrice());
            service.setTitle(serviceDto.getTitle());
            service.setUser(serviceDto.getUser());
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
        List<Service> serviceList = serviceRepository.findAll();
        List<ServiceDto> serviceDtoList = new ArrayList<>();
        for (Service service : serviceList)
            if(service != null)
                serviceDtoList.add(serviceMapper.toDto(service));
        return  serviceDtoList;
    }
}
