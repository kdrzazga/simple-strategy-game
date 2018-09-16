package org.kd.view;

import org.kd.lib.Trimmer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    private final static Map<String, Integer> commandArgumentCountMap = new Hashtable<>(5);

    static {
        commandArgumentCountMap.put("move", 2);
        commandArgumentCountMap.put("build", 2);
        commandArgumentCountMap.put("recruit", 2);
        commandArgumentCountMap.put("end", 0);
        commandArgumentCountMap.put("help", 0);
        commandArgumentCountMap.put("status", 1);
    }

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
        extractAgruments();
    }

    public String getCommand() {
        return command;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public boolean validateCommand() {
        return commandArgumentCountMap.containsKey(command);
    }

    public boolean validateArguments() {
        if (commandArgumentCountMap.get(command) != arguments.size())
            return false;

        for (String arg : arguments) {
            try {
                Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    static List<String> getAvailableCommands() {
        List<String> availableCommands = new Vector<>();
        availableCommands.addAll(commandArgumentCountMap.keySet());
        return availableCommands;
    }

    private void extractAgruments() {
        String args = line.replace(command, "").trim();
        List<String> untrimmedArgs = Arrays.asList(args.split(","));

        untrimmedArgs
                .stream()
                .filter(arg -> arg.length() > 0)
                .forEach(untrimmedArg -> arguments.add(Trimmer.trimBeginningAndEnd(untrimmedArg)));
    }

    private void extractCommand() {
        Pattern pattern = Pattern.compile("[a-z]*");
        Matcher matcher = pattern.matcher(line);
        command = (matcher.find()) ? Trimmer.trimBeginningAndEnd(matcher.group()) : "";
    }
}
