package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.group.domain.Group;
import java.util.List;

public interface UserQueryService {
  List<Group> getUserGroups(Long userId);
}
