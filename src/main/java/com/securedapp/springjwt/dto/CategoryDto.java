package com.securedapp.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long id;
    private String name;
    private List<ServiceDto> serviceList;
    private List<AnnounceDto> announceList;
}
