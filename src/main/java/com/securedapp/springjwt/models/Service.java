package com.securedapp.springjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String phone;

    @OneToMany(mappedBy = "service")
    private List<Announce> announceList;

    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private City city;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
