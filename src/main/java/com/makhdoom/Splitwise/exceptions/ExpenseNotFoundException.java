package com.makhdoom.Splitwise.exceptions;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(Long id) {
        super("Expense not found: " + id);
    }
}
