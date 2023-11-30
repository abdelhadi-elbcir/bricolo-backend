package com.securedapp.springjwt.dto;

import com.securedapp.springjwt.models.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RattingDto {
    private int stars;
    private UserDto userDto;
}
