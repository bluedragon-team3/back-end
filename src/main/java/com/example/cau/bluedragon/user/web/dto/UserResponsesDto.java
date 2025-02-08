package com.example.cau.bluedragon.user.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponsesDto {
  Long id;
  String email;
  String name;
  String studentNumber;
  String sex;
}
