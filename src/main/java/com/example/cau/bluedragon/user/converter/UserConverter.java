package com.example.cau.bluedragon.user.converter;

import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.web.dto.UserResponsesDto;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
  public static UserResponsesDto userToUserResponsesDto(User user) {
    return UserResponsesDto.builder()
        .id(user.getId())
        .signId(user.getSignId())
        .email(user.getEmail())
        .name(user.getName())
        .studentNumber(user.getStudentNumber())
        .sex(String.valueOf(user.getSex()))
        .build();
  }

  public static List<UserResponsesDto> userListToUserResponsesDtoList(List<User> userList) {
    return userList.stream().map(UserConverter::userToUserResponsesDto).toList();
  }
}
