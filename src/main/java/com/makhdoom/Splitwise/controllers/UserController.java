package com.makhdoom.Splitwise.controllers;

import com.makhdoom.Splitwise.dtos.CreateUserRequest;
import com.makhdoom.Splitwise.models.User;
import com.makhdoom.Splitwise.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    public User createUser(CreateUserRequest request) {
        return userService.createUser(request.toUser());
    }
}
