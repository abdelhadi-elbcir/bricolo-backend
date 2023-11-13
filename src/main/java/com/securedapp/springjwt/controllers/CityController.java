package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.CityDto;
import com.securedapp.springjwt.services.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityServiceImpl cityServiceImpl;

    @PostMapping("/add")
    public CityDto create(@RequestBody  CityDto cityDto) {
        return cityServiceImpl.create(cityDto);
    }


    @PutMapping("/edit/{id}")
    public CityDto update(@RequestBody CityDto cityDto,@PathVariable Long id) {
        return cityServiceImpl.update(cityDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return cityServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public CityDto getItem(@PathVariable Long id) {
        return cityServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<CityDto> getList() {
        return cityServiceImpl.getList();
    }
}
