package com.securedapp.springjwt.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @Size(max = 20)
  private String phone;

  @Size(max = 100)
  private String address;

  @Size(max= 100)
  private String about;

  @Size(max = 30)
  private String linkedin;

  @Size(max = 30)
  private String instagram;

  @Size(max = 30)
  private String youtube;

  @Size(max = 30)
  private String facebook;

  @Size(max = 30)
  private String image;

  @Size(max = 30)
  private String firstname;

  @Size(max = 30)
  private String lastname;

  @OneToMany(mappedBy = "user")
  private List<Blog> blogList;

  @OneToMany(mappedBy = "user")
  private List<Comment> commentList;

  @OneToMany(mappedBy = "user")
  private List<Message> messageList;

  @OneToMany(mappedBy = "user")
  private List<Ratting> rattingList;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String phone, String address, String about, String linkedin, String instagram, String youtube, String facebook, String image, String firstname, String lastname) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.address = address;
    this.about = about;
    this.linkedin = linkedin;
    this.instagram = instagram;
    this.youtube = youtube;
    this.facebook = facebook;
    this.image = image;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

}
