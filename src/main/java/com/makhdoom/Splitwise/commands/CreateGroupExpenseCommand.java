package com.makhdoom.Splitwise.commands;

import com.makhdoom.Splitwise.controllers.ExpenseController;
import com.makhdoom.Splitwise.dtos.CreateGroupExpenseRequest;
import com.makhdoom.Splitwise.models.GroupExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateGroupExpenseCommand implements Command {

    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (command.equals(Commands.CREATE_GROUP_EXPENSE_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing create group expense command");
        List<String> tokens = Command.getTokens(input);
        List<Long> userIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        CreateGroupExpenseRequest request = CreateGroupExpenseRequest.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .userIds(userIds)
                .groupId(Long.valueOf(tokens.get(4)))
                .build();
        GroupExpense groupExpense = expenseController.createGroupExpense(request);
        System.out.println("Created group expense with id: " + groupExpense.getId());
    }
}
