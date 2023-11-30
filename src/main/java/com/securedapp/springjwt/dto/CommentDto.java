package com.securedapp.springjwt.dto;

import com.securedapp.springjwt.models.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String Text;
    private UserDto userDto;
}
