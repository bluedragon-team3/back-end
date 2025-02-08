package com.example.cau.bluedragon;

import com.example.cau.bluedragon.group.converter.GroupConverter;
import com.example.cau.bluedragon.group.repository.GroupRepository;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomepageController {

  GroupRepository groupRepository;

  @GetMapping("/")
  public ResponseEntity<List<GroupResponseDto>> home() {
    return ResponseEntity.ok(getRandomGroups());
  }

  private List<GroupResponseDto> getRandomGroups() {
    return GroupConverter.groupListToResponseDtoList(groupRepository.findAll());
  }
}
