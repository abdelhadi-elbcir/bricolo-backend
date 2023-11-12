package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.mappers.ServiceMapper;
import com.securedapp.springjwt.repository.ServiceRepository;
import com.securedapp.springjwt.services.facade.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

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
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public ServiceDto getItem(Long id) {
        return null;
    }

    @Override
    public List<ServiceDto> getList() {
        return null;
    }
}
