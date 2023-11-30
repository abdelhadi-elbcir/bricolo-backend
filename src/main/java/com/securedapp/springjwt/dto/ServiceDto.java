package com.securedapp.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.securedapp.springjwt.models.Announce;
import com.securedapp.springjwt.models.Category;
import com.securedapp.springjwt.models.City;
import com.securedapp.springjwt.models.User;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private String title;
    private double price;
    private String description;
    private String image;
    private String phone;
    private List<AnnounceDto> announceList;
    private CityDto cityDto;
    private CategoryDto categoryDto;
    private UserDto userDto;
}
