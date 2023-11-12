package com.securedapp.springjwt.dto;

import com.securedapp.springjwt.models.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private Long text;
    private User user;
}
