package com.securedapp.springjwt.dto;



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
  private List<BlogDto> blogList;
  private List<CommentDto> commentList;
  private List<MessageDto> messageList;
  private List<RattingDto> rattingList;
  private List<ServiceDto> servicesList;

}
