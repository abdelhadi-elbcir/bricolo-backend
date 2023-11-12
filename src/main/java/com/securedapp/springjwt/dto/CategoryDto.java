package com.securedapp.springjwt.dto;

import com.securedapp.springjwt.models.Announce;
import com.securedapp.springjwt.models.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private String name;
    private List<Service> serviceList;
    private List<Announce> announceList;
}
