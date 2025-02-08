package com.example.cau.bluedragon.group.web.dto;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class GroupDetailRequestDto {
  private Long id;
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
