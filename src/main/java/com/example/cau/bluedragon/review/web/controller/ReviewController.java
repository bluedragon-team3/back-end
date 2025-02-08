package com.example.cau.bluedragon.review.web.controller;

import com.example.cau.bluedragon.group.converter.GroupConverter;
import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.review.converter.ReviewConverter;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.review.service.ReviewQueryService;
import com.example.cau.bluedragon.review.web.dto.ReviewRequestDto;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewQueryService reviewQueryService;

  @GetMapping("/")
  public ResponseEntity<List<GroupResponseDto>> getGroupsToReview() {
    return ResponseEntity.ok(GroupConverter.groupListToResponseDtoList(reviewQueryService.getEndedGroups()));
  }

  @GetMapping("/{groupId}/")
  public ResponseEntity<List<ReviewResponseDto>> getReviews(@PathVariable Long groupId) {
    return ResponseEntity.ok(ReviewConverter.reviewListToReviewResponseDtoList(reviewQueryService.getReviews(groupId)));
  }

  @PostMapping("/")
  public ResponseEntity<ReviewResponseDto> writeReview(@RequestBody ReviewRequestDto reviewRequestDto) {
    ReviewResponseDto reviewResponseDto = reviewQueryService.writeReview(reviewRequestDto);
    return new ResponseEntity<>(reviewResponseDto, HttpStatus.CREATED);
  }
}
