package com.example.cau.bluedragon.user.web.dto;

import lombok.Getter;

@Getter
public class UserRegisterRequestDto {
  String email;
  String password;
  String name;
  String studentNumber;
  String sex;
}
