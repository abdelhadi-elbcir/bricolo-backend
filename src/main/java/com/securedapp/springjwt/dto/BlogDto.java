package com.securedapp.springjwt.dto;

import com.securedapp.springjwt.models.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private String title;
    private String body;
    private String image;
    private User user;
}
