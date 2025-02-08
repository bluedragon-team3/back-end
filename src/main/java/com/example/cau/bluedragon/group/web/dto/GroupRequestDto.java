package com.example.cau.bluedragon.group.web.dto;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class GroupRequestDto {
  @NotBlank
  private String name;

  private String curriculum;

  private String detail;

  @NotBlank
  private Category category;

  @NotBlank
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate finishDate;

  @NotBlank
  private Long peopleLimit;

//  @JsonFormat(pattern = "yyyy-MM-ddTHH:mm")
//  private LocalDateTime createdDate;
}
