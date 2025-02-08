package com.example.cau.bluedragon.review.service;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.review.web.dto.ReviewRequestDto;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import java.util.List;

public interface ReviewQueryService {
  List<Group> getEndedGroups();

  List<Review> getReviews(Long groupId);

  ReviewResponseDto writeReview(ReviewRequestDto reviewRequestDto);
}
