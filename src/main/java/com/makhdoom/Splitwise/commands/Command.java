package com.makhdoom.Splitwise.commands;

import java.util.Arrays;
import java.util.List;

public interface Command {
    boolean matches(String input);
    void execute(String input);

    static List<String> getTokens(String input) {
        return Arrays.stream(input.split(" ")).toList();
    }

    static String getCommand(String input) {
        return getTokens(input).get(0);
    }
}
