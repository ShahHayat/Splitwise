package com.makhdoom.Splitwise.services;

import com.makhdoom.Splitwise.repositories.GroupExpenseRepository;
import com.makhdoom.Splitwise.strategies.GreedySettlementStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SettleService {

    private GroupExpenseRepository groupExpenseRepository;
    private GreedySettlementStrategy greedySettlementStrategy;

    public void settleUp(Long groupId) {
        greedySettlementStrategy.settleUp(null);
    }
}
