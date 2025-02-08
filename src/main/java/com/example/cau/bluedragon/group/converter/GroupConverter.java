package com.example.cau.bluedragon.group.converter;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.converter.UserConverter;
import java.util.List;

public class GroupConverter {
  public static GroupResponseDto groupToResponseDto(Group group) {
    return GroupResponseDto.builder()
        .id(group.getId())
        .owner(UserConverter.userToUserResponsesDto(group.getOwner()))
        .name(group.getName())
        .curriculum(group.getCurriculum())
        .detail(group.getDetail())
        .category(String.valueOf(group.getCategory()))
        .startDate(group.getStartDate())
        .finishDate(group.getFinishDate())
        .peopleLimit(group.getPeopleLimit())
        .createdDate(group.getCreatedDate())
        .build();
  }

  public static List<GroupResponseDto> groupListToResponseDtoList(List<Group> groups) {
    return groups.stream().map(GroupConverter::groupToResponseDto).toList();
  }
}
