package com.example.cau.bluedragon.group.service;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;

public interface GroupCommandService {
  Group createGroup(GroupRequestDto requestDto, Long userId);

  Group endGroup(Long groupId, Long userId);

  void joinGroup(Long groupId);
}
