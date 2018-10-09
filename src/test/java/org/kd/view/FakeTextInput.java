package org.kd.view;

import org.kd.model.orders.Order;
import java.io.ByteArrayInputStream;

public class FakeTextInput extends TextInput {

    public Order readOrder(String order) {
        this.in = new ByteArrayInputStream(order.getBytes());
        return super.readOrder();
    }
}
