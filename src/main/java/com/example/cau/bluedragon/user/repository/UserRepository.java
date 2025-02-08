package com.example.cau.bluedragon.user.repository;

import com.example.cau.bluedragon.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findBySignIdAndPassword(String signId, String password);
}
