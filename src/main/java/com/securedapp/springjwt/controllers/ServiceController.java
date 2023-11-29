package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.ServiceDto;
import com.securedapp.springjwt.services.impl.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceServiceImpl serviceServiceImpl;

    @PostMapping("/add")
    public ServiceDto create(@RequestBody ServiceDto serviceDto) {
        return serviceServiceImpl.create(serviceDto);
    }


    @PutMapping("/edit/{id}")
    public ServiceDto update(@RequestBody ServiceDto serviceDto,@PathVariable Long id) {
        return serviceServiceImpl.update(serviceDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return serviceServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public ServiceDto getItem(@PathVariable Long id) {
        return serviceServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<ServiceDto> getList() {
        return serviceServiceImpl.getList();
    }
    
}
