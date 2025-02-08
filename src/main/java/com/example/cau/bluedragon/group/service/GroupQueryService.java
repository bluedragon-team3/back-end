package com.example.cau.bluedragon.group.service;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;

public interface GroupQueryService {
  List<GroupResponseDto> SearchGroups(Category category);

  List<User> getGroupUsers(Long userId,Long groupId);

  List<GroupResponseDto> getAllGroups();
}
