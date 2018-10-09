package org.kd.view;

import org.kd.lib.Trimmer;
import org.kd.model.orders.Order;

import java.util.*;
import java.util.stream.Collectors;


public class CommandParser {

    private String command;
    private List<String> arguments = new Vector<>();
    private String line;

    public CommandParser(String line) {
        this.line = Trimmer.trimBeginningAndEnd(line);
    }

    public void parse() {

        line = Optional.ofNullable(line)
                .map(String::toLowerCase)
                .orElse("");

        extractCommand();
        extractArguments();
    }

    public Order getCommand() {
        try {
            return Order.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Order.NULL;
        }
    }

    public boolean validateCommand() {
        return getAvailableCommands()
                .contains(command);
    }

    public boolean validateArguments() {
        return getCommand().getRequiredArgumentsCount() == arguments.size();
    }

    static List<String> getAvailableCommands() {
        return Arrays.stream(Order.values())
                .map(Order::toString)
                .collect(Collectors.toList());
    }

    private void extractArguments() {
        String args = line.replace(command, "").trim();
        List<String> untrimmedArgs = Arrays.asList(args.split(","));

        untrimmedArgs
                .stream()
                .filter(arg -> arg.length() > 0)
                .forEach(untrimmedArg -> arguments.add(Trimmer.trimBeginningAndEnd(untrimmedArg)));
    }

    private void extractCommand() {
        int spaceIndex = line.indexOf(" ");
        command = spaceIndex > -1
                ? Trimmer.trimBeginningAndEnd(line.substring(0, line.indexOf(" ")))
                : line;
    }
}
