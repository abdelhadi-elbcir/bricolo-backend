package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.models.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public ServiceDto toDto(Service service){
        return  new ServiceDto(
                service.getTitle(),
                service.getPrice(),
                service.getDescription(),
                service.getImage(),
                service.getPhone(),
                service.getAnnounceList(),
                service.getCity(),
                service.getCategory(),
                service.getUser()
        );
    }

    public Service toEntity(ServiceDto serviceDto){
        Service service = new Service();
        service.setCategory(serviceDto.getCategory());
        service.setCity(serviceDto.getCity());
        service.setAnnounceList(serviceDto.getAnnounceList());
        service.setDescription(serviceDto.getDescription());
        service.setImage(serviceDto.getImage());
        service.setPhone(serviceDto.getPhone());
        service.setPrice(serviceDto.getPrice());
        service.setTitle(serviceDto.getTitle());
        service.setUser(serviceDto.getUser());
        return  service;
    }

}
