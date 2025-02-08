package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.group.converter.GroupConverter;
import com.example.cau.bluedragon.group.converter.GroupUserConverter;
import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.repository.GroupUserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

  private final GroupUserRepository groupUserRepository;

  @Override
  public List<Group> getUserGroups(final Long userId) {
    List<Group> groups = GroupUserConverter.groupUserListToGroupList(groupUserRepository.findByUserId(userId));
    return groups;
  }
}
