package com.example.cau.bluedragon.group.service;

import static com.example.cau.bluedragon.group.converter.GroupConverter.groupToResponseDto;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.domain.enums.Category;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupQueryServiceImpl implements GroupQueryService {

    private final GroupRepository groupRepository;

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
