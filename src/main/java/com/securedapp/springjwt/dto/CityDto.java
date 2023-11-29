package com.securedapp.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.securedapp.springjwt.models.Service;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Service> serviceList;
}
