package com.example.cau.bluedragon.user.domain;

import com.example.cau.bluedragon.group.domain.GroupUser;
import com.example.cau.bluedragon.group.domain.JoinRequest;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.user.domain.enums.Sex;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String password;

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String email;

  @Column(length = 10)
  private String studentNumber;

  @Enumerated(EnumType.STRING)
  private Sex sex;

  private Boolean isDeleted;

  @OneToMany(mappedBy = "user")
  List<GroupUser> groupUsers;

  @OneToMany(mappedBy = "user")
  List<JoinRequest> joinRequests;

  @OneToMany(mappedBy = "user")
  List<Review> review;
}