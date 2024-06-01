package com.makhdoom.Splitwise.controllers;

import com.makhdoom.Splitwise.dtos.CreateGroupRequest;
import com.makhdoom.Splitwise.models.Group;
import com.makhdoom.Splitwise.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;

    public Group createGroup(CreateGroupRequest request) {
        return groupService.createGroup(request);
    }
}
