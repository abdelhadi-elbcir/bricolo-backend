package com.securedapp.springjwt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
