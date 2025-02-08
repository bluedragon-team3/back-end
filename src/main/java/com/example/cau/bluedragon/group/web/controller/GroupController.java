package com.example.cau.bluedragon.group.web.controller;

import com.example.cau.bluedragon.group.converter.GroupConverter;
import com.example.cau.bluedragon.group.domain.Group;
import com.example.cau.bluedragon.group.service.GroupCommandServiceImpl;
import com.example.cau.bluedragon.group.service.GroupQueryServiceImpl;
import com.example.cau.bluedragon.group.web.dto.GroupRequestDto;
import com.example.cau.bluedragon.group.web.dto.GroupResponseDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupCommandServiceImpl groupCommandService;
    private final GroupQueryServiceImpl groupQueryService;

    @PostMapping("/")
    public ResponseEntity<GroupResponseDto> createGroup(@RequestBody GroupRequestDto groupRequestDto, @RequestParam("userId") Long userId) {
        Group group = groupCommandService.createGroup(groupRequestDto, userId);
        GroupResponseDto groupResponseDto = GroupConverter.groupToResponseDto(group);
        return new ResponseEntity<>(groupResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<GroupResponseDto>> getAllGroups() {
        List<GroupResponseDto> groupResponseDtos = groupQueryService.getAllGroups();
        return new ResponseEntity<>(groupResponseDtos, HttpStatus.OK);
    }

}
