package org.kd.model.orders;

import org.kd.model.game_objects.Peasant;

public class OrderBuild extends Order {

    public Peasant builder;

    public OrderBuild(Peasant builder){
        this.builder = builder;
    }

    @Override
    public void execute() {

    }
}
