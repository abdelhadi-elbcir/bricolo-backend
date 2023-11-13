package com.securedapp.springjwt.dto;



import com.securedapp.springjwt.models.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private String phone;
  private String address;
  private String about;
  private String linkedin;
  private String instagram;
  private String youtube;
  private String facebook;
  private String image;
  private String firstname;
  private String lastname;
  private List<Blog> blogList;
  private List<Comment> commentList;
  private List<Message> messageList;
  private List<Ratting> rattingList;
  private List<Service> servicesList;

}
