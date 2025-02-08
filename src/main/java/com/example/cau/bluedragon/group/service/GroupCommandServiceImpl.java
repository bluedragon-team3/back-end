package com.example.cau.bluedragon.group.service;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.domain.GroupUser;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.repository.GroupUserRepository;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;
import com.example.cau.bluedragon.user.domain.User;
import com.example.cau.bluedragon.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupCommandServiceImpl implements GroupCommandService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final GroupUserRepository groupUserRepository;

    @Override
    @Transactional
    public Group createGroup(GroupRequestDto requestDto, Long userId) {
        // 유저 찾기
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("해당 아이디를 가진 회원이 존재하지 않습니다."));

        // 그룹 생성
        Group group = new Group().builder()
            .name(requestDto.getName())
            .curriculum(requestDto.getCurriculum())
            .detail(requestDto.getDetail())
            .category(requestDto.getCategory())
            .peopleLimit(requestDto.getPeopleLimit())
            .createdDate(LocalDateTime.now())
            .startDate(requestDto.getStartDate())
            .finishDate(requestDto.getFinishDate())
            .isEnded(false)
            .isDeleted(false)
            .owner(user) // 소모임장
            .build();
        groupRepository.save(group);

        // 그룹에 본인 참여
        GroupUser groupUser = new GroupUser().builder()
            .group(group)
            .user(user)
            .build();
        groupUserRepository.save(groupUser);

        return group;
    }

    @Override
    @Transactional
    public void joinGroup(Long groupId) {

    }
}
