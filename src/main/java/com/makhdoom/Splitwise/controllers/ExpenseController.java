package com.makhdoom.Splitwise.controllers;

import com.makhdoom.Splitwise.dtos.CreateExpenseRequest;
import com.makhdoom.Splitwise.dtos.CreateGroupExpenseRequest;
import com.makhdoom.Splitwise.dtos.CreateUserExpenseRequest;
import com.makhdoom.Splitwise.models.Expense;
import com.makhdoom.Splitwise.models.GroupExpense;
import com.makhdoom.Splitwise.models.UserExpense;
import com.makhdoom.Splitwise.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ExpenseController {

    private ExpenseService expenseService;

    public Expense createExpense(CreateExpenseRequest request) {
        return expenseService.createExpense(request);
    }

    public Expense getExpense(Long id) {
        return expenseService.getExpense(id);
    }

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        return expenseService.addUserExpense(request);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request) {
        return expenseService.createGroupExpense(request);
    }
}
