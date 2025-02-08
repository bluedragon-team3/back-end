package com.example.cau.bluedragon.group.service;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.example.cau.bluedragon.group.web.dto.GroupDetailResponseDto;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;

public interface GroupQueryService {
  GroupDetailResponseDto getGroupDetail(Long groupId, Long userId);

  List<GroupResponseDto> SearchGroups(Category category);

  List<User> getGroupUsers(Long userId,Long groupId);

  List<GroupResponseDto> getAllGroups();
}
