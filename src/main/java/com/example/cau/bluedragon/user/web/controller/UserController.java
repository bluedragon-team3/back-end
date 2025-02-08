package com.example.cau.bluedragon.user.web.controller;

import com.example.cau.bluedragon.group.converter.GroupConverter;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.converter.UserConverter;
import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.service.UserCommandService;
import com.example.cau.bluedragon.user.service.UserQueryService;
import com.example.cau.bluedragon.user.web.dto.UserLoginRequestDto;
import com.example.cau.bluedragon.user.web.dto.UserRegisterRequestDto;
import com.example.cau.bluedragon.user.web.dto.UserResponsesDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserCommandService userCommandService;
  private final UserQueryService userQueryService;

  @PostMapping("/login/")
  public ResponseEntity<UserResponsesDto> login(@RequestBody UserLoginRequestDto requestDto) {
    return ResponseEntity.ok(UserConverter.userToUserResponsesDto(userCommandService.loginUser(requestDto)));
  }

  @PostMapping("/register/")
  public ResponseEntity<UserResponsesDto> register(@RequestBody UserRegisterRequestDto requestDto) {
    return ResponseEntity.ok(UserConverter.userToUserResponsesDto(userCommandService.registerUser(requestDto)));
  }

  @GetMapping("/mygroups/")
  public ResponseEntity<List<GroupResponseDto>> getMyGroups(@RequestParam Long userId) {
    return ResponseEntity.ok(GroupConverter.groupListToResponseDtoList(userQueryService.getUserGroups(userId)));
  }
}
