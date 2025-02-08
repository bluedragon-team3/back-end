package com.example.cau.bluedragon.group.repository;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.domain.GroupUser;
import com.example.cau.bluedragon.user.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {
    Optional<GroupUser> findByGroupAndUser(Group group, User user);

    // 그룹에 속한 사용자 수를 세는 메서드
    @Query("SELECT COUNT(g) FROM GroupUser g WHERE g.group = :group")
    Long countByGroup(@Param("group") Group group);

  List<GroupUser> findAllByUserId(Long userId);

  List<GroupUser> findAllByGroupId(Long groupId);
}
