package com.makhdoom.Splitwise.commands;

import com.makhdoom.Splitwise.controllers.ExpenseController;
import com.makhdoom.Splitwise.dtos.CreateUserExpenseRequest;
import com.makhdoom.Splitwise.models.ExpenseType;
import com.makhdoom.Splitwise.models.UserExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AddUserExpenseCommand implements Command {

    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (command.equals(Commands.ADD_USER_EXPENSE)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing add user expense command");
        List<String> tokens = Command.getTokens(input);
        CreateUserExpenseRequest request = CreateUserExpenseRequest.builder()
                .userId(Long.valueOf(tokens.get(1)))
                .expenseId(Long.valueOf(tokens.get(2)))
                .amount(Double.valueOf(tokens.get(3)))
                .type(ExpenseType.valueOf(tokens.get(4)))
                .build();

        UserExpense expense = expenseController.addUserExpense(request);
        System.out.println("Created user expense with id: " + expense.getId());
    }
}
