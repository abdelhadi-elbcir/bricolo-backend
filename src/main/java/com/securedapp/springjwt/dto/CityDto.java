package com.securedapp.springjwt.dto;

import com.securedapp.springjwt.models.Service;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private String name;
    private List<Service> serviceList;
}
