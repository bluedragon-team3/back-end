package com.example.cau.bluedragon.user.web.controller;

import com.example.cau.bluedragon.group.converter.GroupConverter;
import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.review.converter.ReviewConverter;
import com.example.cau.bluedragon.review.web.dto.ReviewResponseDto;
import com.example.cau.bluedragon.user.converter.UserConverter;
import com.example.cau.bluedragon.user.service.MypageQueryService;
import com.example.cau.bluedragon.user.web.dto.UserResponsesDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

  private final MypageQueryService mypageQueryService;

  @GetMapping("/")
  public ResponseEntity<List<GroupResponseDto>> getMyGroup(@RequestParam Long userId) {
    return ResponseEntity.ok(GroupConverter.groupListToResponseDtoList(mypageQueryService.getUserGroups(userId)));
  }

  @GetMapping("/{groupId}/")
  public ResponseEntity<GroupResponseDto> getGroupDetail(@PathVariable Long groupId) {
    return ResponseEntity.ok(GroupConverter.groupToResponseDto(mypageQueryService.getGroup(groupId)));
  }

  @GetMapping("/{groupId}/studyMate/")
  public ResponseEntity<List<UserResponsesDto>> getStudyMate(@PathVariable Long groupId) {
    return ResponseEntity.ok(UserConverter.userListToUserResponsesDtoList(mypageQueryService.getGroupUsers(groupId)));
  }

  @GetMapping("/{groupId}/review")
  public ResponseEntity<List<ReviewResponseDto>> getGroupReview(@PathVariable Long groupId) {
    return ResponseEntity.ok(ReviewConverter.reviewListToReviewResponseDtoList(
        mypageQueryService.getGroupReviews(groupId)
    ));
  }
}
