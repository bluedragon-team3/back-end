package com.example.cau.bluedragon.review.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class ReviewResponseDto {
  Long id;
  Long memberId;
  Long groupId;
  String content;

  @JsonFormat(pattern = "yyyy-MM-ddTHH:mm")
  LocalDateTime createdDate;
}
