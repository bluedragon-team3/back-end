package com.example.cau.bluedragon.group.web.dto;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.example.cau.bluedragon.member.domain.Member;
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
public class GroupResponseDto {
  private Long id;
  private Member owner;
  private String name;
  private String curriculum;
  private String detail;
  private Category category;

  @JsonFormat(pattern = "yyyy-MM-ddTHH:mm")
  private LocalDateTime startDate;

  @JsonFormat(pattern = "yyyy-MM-ddTHH:mm")
  private LocalDateTime finishDate;

  private Long peopleLimit;

  @JsonFormat(pattern = "yyyy-MM-ddTHH:mm")
  private LocalDateTime createdAt;
}
