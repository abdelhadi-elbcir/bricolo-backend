package com.securedapp.springjwt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private String image;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
