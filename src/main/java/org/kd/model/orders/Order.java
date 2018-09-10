package org.kd.model.orders;

public abstract class Order {

    protected byte totalDuration;
    protected byte currentDuration;

    void execute(){}

    byte getTotalDuration(){
        return totalDuration;
    }

    byte getCurrentDuration(){
        return currentDuration;
    }
}
