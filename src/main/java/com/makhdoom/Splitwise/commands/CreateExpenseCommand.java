package com.makhdoom.Splitwise.commands;

import com.makhdoom.Splitwise.controllers.ExpenseController;
import com.makhdoom.Splitwise.dtos.CreateExpenseRequest;
import com.makhdoom.Splitwise.models.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateExpenseCommand implements Command {

    private ExpenseController expenseController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (command.equals(Commands.CREATE_EXPENSE_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing creating expense command");
        List<String> tokens = Command.getTokens(input);
        List<Long> userIds = Arrays.stream(tokens.get(3).split(","))
                .map(Long::valueOf)
                .toList();
        CreateExpenseRequest request = CreateExpenseRequest.builder()
                .description(tokens.get(1))
                .amount(Double.valueOf(tokens.get(2)))
                .userIds(userIds)
                .build();
        Expense expense = expenseController.createExpense(request);
        System.out.println("Created expense with id: " + expense.getId());
    }
}
