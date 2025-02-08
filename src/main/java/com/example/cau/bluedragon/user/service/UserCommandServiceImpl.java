package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.apiPayloadd.code.status.ErrorStatus;
import com.example.cau.bluedragon.exception.handler.GeneralExceptionHandler;
import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.domain.enums.Sex;
import com.example.cau.bluedragon.user.repository.UserRepository;
import com.example.cau.bluedragon.user.web.dto.UserLoginRequestDto;
import com.example.cau.bluedragon.user.web.dto.UserRegisterRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

  private final UserRepository userRepository;

  @Override
  public User loginUser(final UserLoginRequestDto requestDto) {
    User user = userRepository.findBySignIdAndPassword(requestDto.getSignId(), requestDto.getPassword()).orElseThrow();
    return user;
  }

  @Override
  public User registerUser(final UserRegisterRequestDto requestDto) {
    if(!requestDto.getEmail().contains("@cau.ac.kr"))
      throw new GeneralExceptionHandler(ErrorStatus.EMAIL_NOT_VAILD);

    User user = User.builder()
        .signId(requestDto.getSignId())
        .email(requestDto.getEmail())
        .password(requestDto.getPassword())
        .name(requestDto.getName())
        .studentNumber(requestDto.getStudentNumber())
        .sex(Sex.valueOf(requestDto.getSex()))
        .build();
    return userRepository.save(user);
  }
}
