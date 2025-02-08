package com.example.cau.bluedragon.review.domain;

import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
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
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  private Boolean isDeleted;

  @CreatedDate
  private LocalDateTime createdAt;

  @ManyToOne
  private Group group;

  @ManyToOne
  private Member member;
}
