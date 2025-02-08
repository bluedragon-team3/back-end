package com.example.cau.bluedragon.review.service;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.review.repository.ReviewRepository;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

  private final ReviewRepository reviewRepository;
  private final GroupRepository groupRepository;

  @Override
  public List<Group> getEndedGroups() {
    List<Group> groups = groupRepository.findAllByIsEnded(true);
    return groups;
  }

  @Override
  public List<Review> getReviews(final Long groupId) {
    List<Review> reviews = reviewRepository.findAllByGroupId(groupId);
    return reviews;
  }
}
