package com.securedapp.springjwt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Text;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
