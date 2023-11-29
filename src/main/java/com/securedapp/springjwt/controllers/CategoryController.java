package com.securedapp.springjwt.controllers;

import com.securedapp.springjwt.dto.CategoryDto;
import com.securedapp.springjwt.services.impl.BlogServiceImpl;
import com.securedapp.springjwt.services.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping("/add")
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryServiceImpl.create(categoryDto);
    }

    @PutMapping("/edit/{id}")
    public CategoryDto update(@RequestBody CategoryDto categoryDto,@PathVariable Long id) {
        return categoryServiceImpl.update(categoryDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return categoryServiceImpl.delete(id);
    }

    @GetMapping("/get/{id}")
    public CategoryDto getBlog(@PathVariable Long id) {
        return categoryServiceImpl.getItem(id);
    }

    @GetMapping("/all")
    public List<CategoryDto> getListBlogs() {
        return categoryServiceImpl.getList();
    }


}
