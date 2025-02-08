package com.example.cau.bluedragon.group.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class JoinGroupRequestDto {
  @NotBlank
  private boolean isJoined;
}
