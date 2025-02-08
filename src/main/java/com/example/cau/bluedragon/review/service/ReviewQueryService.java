package com.example.cau.bluedragon.review.service;

import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import java.util.List;

public interface ReviewQueryService {
  List<GroupResponseDto> getEndedGroups();

  List<ReviewResponseDto> getReviews(Long groupId);
}
