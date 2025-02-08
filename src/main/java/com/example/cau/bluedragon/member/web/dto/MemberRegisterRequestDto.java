package com.example.cau.bluedragon.member.web.dto;

import lombok.Getter;

@Getter
public class MemberRegisterRequestDto {
  String email;
  String password;
  String name;
  String studentNumber;
  String sex;
}
