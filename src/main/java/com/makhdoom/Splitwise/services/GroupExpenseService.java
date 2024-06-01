package com.makhdoom.Splitwise.services;

import com.makhdoom.Splitwise.models.GroupExpense;
import com.makhdoom.Splitwise.repositories.GroupExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupExpenseService {

    private GroupExpenseRepository groupExpenseRepository;

    public GroupExpense createGroupExpense(GroupExpense groupExpense) {
        return groupExpenseRepository.save(groupExpense);
    }
}
