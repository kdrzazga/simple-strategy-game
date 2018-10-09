package org.kd.model;

import org.kd.model.orders.Order;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrderTest {

    @Test
    public void testToString(){
        assertEquals("move", Order.MOVE.toString());
        assertEquals("recruit", Order.RECRUIT.toString());
    }

}
