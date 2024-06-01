package com.makhdoom.Splitwise.services;

import com.makhdoom.Splitwise.models.UserExpense;
import com.makhdoom.Splitwise.repositories.UserExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserExpenseService {

    private UserExpenseRepository userExpenseRepository;

    public UserExpense createUserExpense(UserExpense userExpense) {
        return userExpenseRepository.save(userExpense);
    }
}
