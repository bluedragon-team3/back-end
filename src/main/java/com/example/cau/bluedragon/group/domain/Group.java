package com.example.cau.bluedragon.group.domain;

import com.example.cau.bluedragon.group.domain.enums.Category;
import com.example.cau.bluedragon.review.domain.Review;
import com.example.cau.bluedragon.member.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "crew")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  private String name;

  @Column(length = 50)
  private String curriculum;

  @Column(length = 50)
  private String detail;

  @Enumerated(EnumType.STRING)
  private Category category;

  private Long peopleLimit;

  @CreatedDate
  private LocalDateTime createdAt;

  private LocalDateTime startDate;

  private LocalDateTime finishDate;

  private Boolean idEnded;

  private Boolean isDeleted;

  @ManyToOne
  private Member owner;

  @OneToMany(mappedBy = "group")
  List<GroupMember> groupMembers;

  @OneToMany(mappedBy = "group")
  List<JoinRequest> joinRequests;

  @OneToMany(mappedBy = "group")
  List<Review> review;
}
