package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.group.converter.GroupUserConverter;
import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.repository.GroupUserRepository;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.review.repository.ReviewRepository;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageQueryServiceImpl implements MypageQueryService {

  private final GroupUserRepository groupUserRepository;
  private  final GroupRepository groupRepository;
  private final ReviewRepository reviewRepository;

  @Override
  public List<Group> getUserGroups(final Long userId) {
    List<Group> groups = GroupUserConverter.groupUserListToGroupList(groupUserRepository.findAllByUserId(userId));
    return groups;
  }

  @Override
  public Group getGroup(final Long groupId) {
    return groupRepository.findById(groupId).orElseThrow();
  }

  @Override
  public List<User> getGroupUsers(final Long groupId) {
    List<User> users = GroupUserConverter.groupUserListToUserList(groupUserRepository.findAllByGroupId(groupId));
    return users;
  }

  @Override
  public List<Review> getGroupReviews(final Long groupId) {
    return reviewRepository.findAllByGroupId(groupId);
  }
}
