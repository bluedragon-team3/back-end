package com.example.cau.bluedragon.review.converter;

import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import com.example.cau.bluedragon.user.converter.UserConverter;
import java.util.List;

public class ReviewConverter {
  public static ReviewResponseDto reviewToReviewResponseDto(Review review) {
    return ReviewResponseDto.builder()
        .id(review.getId())
        .user(UserConverter.userToUserResponsesDto(review.getUser()))
        .build();
  }

  public static List<ReviewResponseDto> reviewListToReviewResponseDtoList(List<Review> reviews) {
    return reviews.stream().map(ReviewConverter::reviewToReviewResponseDto).toList();
  }
}
