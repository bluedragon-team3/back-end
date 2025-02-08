package com.example.cau.bluedragon.group.web.dto;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class GroupRequestDto {
  private String name;
  private String curriculum;
  private String detail;
  private Category category;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate finishDate;

  private Long peopleLimit;

//  @JsonFormat(pattern = "yyyy-MM-ddTHH:mm")
//  private LocalDateTime createdDate;
}
