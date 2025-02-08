package com.example.cau.bluedragon.group.repository;

import com.example.cau.bluedragon.group.domain.Group;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

  List<Group> findAllByIdEnded(Boolean idEnded);
}
