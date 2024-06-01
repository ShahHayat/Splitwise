package com.makhdoom.Splitwise.commands;

import com.makhdoom.Splitwise.controllers.GroupController;
import com.makhdoom.Splitwise.dtos.CreateGroupRequest;
import com.makhdoom.Splitwise.models.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupCommand implements Command {

    private GroupController groupController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (command.equals(Commands.CREATE_GROUP_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> tokens = Command.getTokens(input);
        List<Long> memberIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        CreateGroupRequest request = CreateGroupRequest.builder()
                .name(tokens.get(1))
                .createdBy(Long.valueOf(tokens.get(2)))
                .memberIds(memberIds)
                .build();
        Group group = groupController.createGroup(request);
        System.out.println("Created group with id: " + group.getId());
    }
}
