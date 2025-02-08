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
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupCommandServiceImpl implements GroupCommandService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final GroupUserRepository groupUserRepository;

    @Override
    @Transactional
    public Group createGroup(GroupRequestDto requestDto, Long userId) {
        // 유저 찾기
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

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
    public void endGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

        // 내가 소모임장이 아닌 경우
        if (!user.equals(group.getOwner())) {
            throw new RuntimeException("소모임장만 모임을 종료시킬 수 있습니다.");
        }

        // 이미 종료된 소모임인 경우
        if (group.getIsEnded()) {
            throw new RuntimeException("이미 종료된 소모임입니다.");
        }

        // 내가 소모임장이고, 아직 종료되지 않은 소모임인 경우
        group.endGroup(); // 소모임 종료
    }

    @Override
    @Transactional
    public void joinGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("해당 ID를 가진 회원이 존재하지 않습니다."));

        Optional<GroupUser> groupUser = groupUserRepository.findByGroupAndUser(group, user);

        // 이미 신청했던 소모임의 경우
        if (groupUser.isPresent()) {
            throw new RuntimeException("이미 참여중입니다.");
        }

        // 이미 소모임 인원이 다 찬 경우
        Long numberOfPeople = groupUserRepository.countByGroup(group);
        if (numberOfPeople == group.getPeopleLimit()) {
            throw new RuntimeException("인원이 다 찼습니다.");
        }

        // 소모임 참여하기
        GroupUser newGroupUser = new GroupUser().builder()
            .group(group)
            .user(user)
            .isDeleted(false)
            .build();
        groupUserRepository.save(newGroupUser);
    }
}
