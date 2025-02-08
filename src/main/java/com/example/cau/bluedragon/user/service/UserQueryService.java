package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;

public interface UserQueryService {
  List<GroupResponseDto> getUserGroups(Long userId);
}
