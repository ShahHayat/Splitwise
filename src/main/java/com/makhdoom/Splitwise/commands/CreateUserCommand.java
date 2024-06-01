package com.makhdoom.Splitwise.commands;

import com.makhdoom.Splitwise.controllers.UserController;
import com.makhdoom.Splitwise.dtos.CreateUserRequest;
import com.makhdoom.Splitwise.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CreateUserCommand implements Command {

    private UserController userController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (command.equals(Commands.RESISTER_USER_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> tokens = Command.getTokens(input);

        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .name(tokens.get(1))
                .email(tokens.get(2))
                .password(tokens.get(3))
                .phoneNumber(tokens.get(4))
                .build();

        User user = userController.createUser(createUserRequest);
        System.out.println("Created user with id: " + user.getId());
    }
}
