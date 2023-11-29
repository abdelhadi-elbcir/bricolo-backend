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
    private List<Announce> announceList;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private City city;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
}
