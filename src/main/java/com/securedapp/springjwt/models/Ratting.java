package com.securedapp.springjwt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ratting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int stars;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
