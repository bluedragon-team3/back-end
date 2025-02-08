package com.example.cau.bluedragon.review.web.dto;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ReviewRequestDto {
    @NotBlank
    private String content;

    @NotNull
    private Long groupId;

    @NotNull
    private Long userId;
}
