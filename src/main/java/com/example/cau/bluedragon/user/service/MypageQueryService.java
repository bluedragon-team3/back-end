package com.example.cau.bluedragon.user.service;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;

public interface MypageQueryService {

  List<Group> getUserGroups(Long userId);

  Group getGroup(Long groupId);

  List<User> getGroupUsers(Long groupId);

  List<Review> getGroupReviews(Long groupId);

}
