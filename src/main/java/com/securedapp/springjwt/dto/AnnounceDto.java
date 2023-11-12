package com.securedapp.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.securedapp.springjwt.models.Category;
import com.securedapp.springjwt.models.Service;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnounceDto {

    private String title;
    private String body;
    private String image;
    private Service service;
    private Category category;

}
