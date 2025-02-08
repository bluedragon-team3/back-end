package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.web.dto.UserLoginRequestDto;
import com.example.cau.bluedragon.user.web.dto.UserRegisterRequestDto;

public interface UserCommandService {

  User loginUser(UserLoginRequestDto requestDto);

  User registerUser(UserRegisterRequestDto requestDto);

}
