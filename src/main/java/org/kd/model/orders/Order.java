package org.kd.model.orders;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public enum Order {

    BUILD, MOVE, RECRUIT, END, HELP, STATUS, EXIT, NULL;

    private List<String> arguments;
    protected byte totalDuration;
    protected byte currentDuration;

    private final static Map<Order, Integer> orderArgumentsCountMap = new Hashtable<>(6);

    static {
        orderArgumentsCountMap.put(MOVE, 2);
        orderArgumentsCountMap.put(BUILD, 2);
        orderArgumentsCountMap.put(RECRUIT, 2);
        orderArgumentsCountMap.put(END, 0);
        orderArgumentsCountMap.put(HELP, 0);
        orderArgumentsCountMap.put(STATUS, 1);
        orderArgumentsCountMap.put(EXIT, 0);
    }

    void execute() {
    }

    byte getTotalDuration() {
        return totalDuration;
    }

    byte getCurrentDuration() {
        return currentDuration;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String toString() {
        return this.name().toLowerCase();
    }

    public int getRequiredArgumentsCount(){
        return orderArgumentsCountMap.get(this);
    }
}
