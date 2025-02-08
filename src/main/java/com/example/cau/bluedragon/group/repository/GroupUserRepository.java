package com.example.cau.bluedragon.group.repository;

import com.example.cau.bluedragon.group.domain.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {

}
