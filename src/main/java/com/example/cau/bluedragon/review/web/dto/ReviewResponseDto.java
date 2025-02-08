package com.example.cau.bluedragon.review.web.dto;

import com.example.cau.bluedragon.user.web.dto.UserResponsesDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDto {
  Long id;
  UserResponsesDto user;
  String content;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
  LocalDateTime createdDate;
}
