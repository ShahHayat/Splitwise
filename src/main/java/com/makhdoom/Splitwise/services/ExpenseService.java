package com.makhdoom.Splitwise.services;

import com.makhdoom.Splitwise.dtos.CreateExpenseRequest;
import com.makhdoom.Splitwise.dtos.CreateGroupExpenseRequest;
import com.makhdoom.Splitwise.dtos.CreateUserExpenseRequest;
import com.makhdoom.Splitwise.exceptions.ExpenseNotFoundException;
import com.makhdoom.Splitwise.exceptions.GroupNotFoundException;
import com.makhdoom.Splitwise.models.*;
import com.makhdoom.Splitwise.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {

    private UserService userService;
    private UserExpenseService userExpenseService;
    private ExpenseRepository expenseRepository;
    private GroupService groupService;
    private GroupExpenseService groupExpenseService;

    public Expense createExpense(CreateExpenseRequest request) {
        List<User> users = userService.getUsers(request.getUserIds());
        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();
        return expenseRepository.save(expense);
    }

    public Expense getExpense(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public UserExpense addUserExpense(CreateUserExpenseRequest request) {
        User user = userService.getUser(request.getUserId());
        Expense expense = expenseRepository
                .findById(request.getExpenseId())
                .orElseThrow(() -> new ExpenseNotFoundException(request.getExpenseId()));
        UserExpense userExpense = UserExpense.builder()
                .user(user)
                .expense(expense)
                .amount(request.getAmount())
                .type(request.getType())
                .build();
        return userExpenseService.createUserExpense(userExpense);
    }

    public GroupExpense createGroupExpense(CreateGroupExpenseRequest request) {
        Group group = groupService.getGroup(request.getGroupId());
        if (group == null) {
            throw new GroupNotFoundException(request.getGroupId());
        }
        List<User> users = userService.getUsers(request.getUserIds());
        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .users(users)
                .status(ExpenseStatus.PENDING)
                .build();
        expenseRepository.save(expense);
        GroupExpense groupExpense = GroupExpense.builder()
                .group(group)
                .expense(expense)
                .build();
        return groupExpenseService.createGroupExpense(groupExpense);
    }
}
