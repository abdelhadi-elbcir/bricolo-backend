package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.RattingDto;
import com.securedapp.springjwt.services.impl.RattingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratt")
public class RattingController {
    
    @Autowired
    private RattingServiceImpl rattingServiceImpl;

    @PostMapping("/add")
    public RattingDto create(@RequestBody RattingDto rattingDto) {
        return rattingServiceImpl.create(rattingDto);
    }

    @PutMapping("/edit/{id}")
    public RattingDto update(@RequestBody RattingDto rattingDto,@PathVariable Long id) {
        return rattingServiceImpl.update(rattingDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return rattingServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public RattingDto getRatting(@PathVariable Long id) {
        return rattingServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<RattingDto> getListRattings() {
        return rattingServiceImpl.getList();
    }
    
}
