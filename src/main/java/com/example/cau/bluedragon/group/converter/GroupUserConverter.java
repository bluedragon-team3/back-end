package com.example.cau.bluedragon.group.converter;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.domain.GroupUser;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;

public class GroupUserConverter {

  public static List<Group> groupUserListToGroupList(List<GroupUser> groupUserList) {
    return groupUserList.stream().map(GroupUser::getGroup).toList();
  }

  public static List<User> groupUserListToUserList(List<GroupUser> groupUserList) {
    return groupUserList.stream().map(GroupUser::getUser).toList();
  }
}
