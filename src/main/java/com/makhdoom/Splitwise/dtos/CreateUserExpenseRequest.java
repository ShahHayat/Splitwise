package com.makhdoom.Splitwise.dtos;

import com.makhdoom.Splitwise.models.ExpenseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserExpenseRequest {
    private Long userId;
    private Long expenseId;
    private Double amount;
    private ExpenseType type;
}
