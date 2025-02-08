package com.example.cau.bluedragon.user.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserLoginRequestDto {
  @NotBlank
  String signId;

  @NotBlank
  String password;
}
