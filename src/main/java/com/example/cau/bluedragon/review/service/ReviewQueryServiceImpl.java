package com.example.cau.bluedragon.review.service;

import static com.example.cau.bluedragon.review.converter.ReviewConverter.reviewToReviewResponseDto;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.review.repository.ReviewRepository;
import com.example.cau.bluedragon.review.web.dto.ReviewRequestDto;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

  private final ReviewRepository reviewRepository;
  private final GroupRepository groupRepository;
  private final UserRepository userRepository;

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

  @Override
  public ReviewResponseDto writeReview(ReviewRequestDto requestDto) {
    System.out.println(requestDto.getContent());
    System.out.println(requestDto.getGroupId());
    System.out.println(requestDto.getUserId());
    Group group = groupRepository.findById(requestDto.getGroupId())
        .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

    User user = userRepository.findById(requestDto.getUserId())
        .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

    Review review = new Review().builder()
        .content(requestDto.getContent())
        .isDeleted(false)
        .createdAt(LocalDateTime.now())
        .group(group)
        .user(user)
        .build();
    reviewRepository.save(review);

    ReviewResponseDto reviewResponseDto = reviewToReviewResponseDto(review);
    return reviewResponseDto;
  }
}
