package com.example.cau.bluedragon.user.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRegisterRequestDto {
  @NotBlank
  String signId;

  @NotBlank
  String email;

  @NotBlank
  String password;

  @NotBlank
  String name;

  @NotBlank
  String studentNumber;

  @NotBlank
  String sex;
}
