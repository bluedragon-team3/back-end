package com.example.cau.bluedragon.group.service;

import static com.example.cau.bluedragon.group.converter.GroupConverter.groupToResponseDto;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.domain.enums.Category;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.web.dto.GroupDetailResponseDto;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.converter.UserConverter;
import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupQueryServiceImpl implements GroupQueryService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Override
    public GroupDetailResponseDto getGroupDetail(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new RuntimeException("해당 ID를 가진 그룹이 없습니다."));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("해당 아이디를 가진 회원이 존재하지 않습니다."));

        Boolean isOwner = user.equals(group.getOwner());

        GroupDetailResponseDto groupDetailResponseDto = new GroupDetailResponseDto().builder()
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
            .isEnded(group.getIsEnded())
            .isOwner(isOwner)
            .build();

        return groupDetailResponseDto;
    }

    @Override
    public List<GroupResponseDto> SearchGroups(Category category) {
        return List.of();
    }

    @Override
    public List<User> getGroupUsers(Long userId, Long groupId) {
        return List.of();
    }

    @Override
    public List<GroupResponseDto> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        List<GroupResponseDto> groupResponseDtos = groups.stream()
            .map(group -> groupToResponseDto(group))
            .collect(Collectors.toList());

        return groupResponseDtos;
    }
}
