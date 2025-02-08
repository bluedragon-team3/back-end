package com.example.cau.bluedragon.review.service;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.review.domain.Review;
import java.util.List;

public interface ReviewQueryService {
  List<Group> getEndedGroups();

  List<Review> getReviews(Long groupId);
}
