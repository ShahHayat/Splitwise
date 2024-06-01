package com.makhdoom.Splitwise.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserExpense extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType type;
}
