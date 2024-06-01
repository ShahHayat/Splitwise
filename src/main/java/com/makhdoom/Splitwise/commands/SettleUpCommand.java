package com.makhdoom.Splitwise.commands;

import com.makhdoom.Splitwise.controllers.SettleController;
import com.makhdoom.Splitwise.models.GroupExpense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SettleUpCommand implements Command {

    private SettleController settleController;

    @Override
    public boolean matches(String input) {
        String command = Command.getCommand(input);
        if (command.equals(Commands.SETTLE_UP_COMMAND)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing settle command");
        List<String> tokens = Command.getTokens(input);
        Long groupId = Long.valueOf(tokens.get(1));
        settleController.settleUp(groupId);
        System.out.println("Settled the transactions for group: " + groupId);
    }
}
