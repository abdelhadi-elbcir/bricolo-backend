package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.models.Ratting;
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
    public Ratting create(@RequestBody Ratting ratting) {
        return rattingServiceImpl.create(ratting);
    }

    @PutMapping("/edit/{id}")
    public Ratting update(@RequestBody Ratting ratting,@PathVariable Long id) {
        return rattingServiceImpl.update(ratting, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return rattingServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public Ratting getRatting(@PathVariable Long id) {
        return rattingServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<Ratting> getListRattings() {
        return rattingServiceImpl.getList();
    }
    
}
