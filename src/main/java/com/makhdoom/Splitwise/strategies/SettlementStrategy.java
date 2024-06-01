package com.makhdoom.Splitwise.strategies;

import com.makhdoom.Splitwise.dtos.SettleUpTransaction;
import com.makhdoom.Splitwise.models.Expense;

import java.util.List;

public interface SettlementStrategy {
    List<SettleUpTransaction> settleUp(List<Expense> expenses);
}
