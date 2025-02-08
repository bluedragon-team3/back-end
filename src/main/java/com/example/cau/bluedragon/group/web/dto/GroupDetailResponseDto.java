package com.example.cau.bluedragon.group.web.dto;

import com.example.cau.bluedragon.user.web.dto.UserResponsesDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDetailResponseDto {
    private Long id;
    private UserResponsesDto owner;
    private String name;
    private String curriculum;
    private String detail;
    private String category;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;

    private Long peopleLimit;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdDate;

    private Boolean isEnded;

    private Boolean isOwner;
}
