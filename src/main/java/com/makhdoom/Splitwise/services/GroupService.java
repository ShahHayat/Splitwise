package com.makhdoom.Splitwise.services;

import com.makhdoom.Splitwise.dtos.CreateGroupRequest;
import com.makhdoom.Splitwise.models.Group;
import com.makhdoom.Splitwise.models.User;
import com.makhdoom.Splitwise.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private UserService userService;
    private GroupRepository groupRepository;

    public Group createGroup(CreateGroupRequest request) {
        User createdBy = userService.getUser(request.getCreatedBy());
        List<User> members = userService.getUsers(request.getMemberIds());
        Group group = Group.builder()
                .name(request.getName())
                .createdBy(createdBy)
                .members(members)
                .admins(List.of(createdBy))
                .build();
        return groupRepository.save(group);
    }

    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }
}
