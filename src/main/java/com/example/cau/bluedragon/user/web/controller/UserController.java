package com.example.cau.bluedragon.user.web.controller;

import com.example.cau.bluedragon.user.converter.UserConverter;
import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.service.UserCommandService;
import com.example.cau.bluedragon.user.web.dto.UserLoginRequestDto;
import com.example.cau.bluedragon.user.web.dto.UserResponsesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  UserCommandService userCommandService;

  @PostMapping("/login/")
  public ResponseEntity<UserResponsesDto> login(@RequestBody UserLoginRequestDto requestDto) {
    return ResponseEntity.ok(UserConverter.userToUserResponsesDto(userCommandService.loginUser(requestDto)));
  }
}
