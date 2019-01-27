package org.kd.view;

import org.kd.model.orders.Order;
import java.io.ByteArrayInputStream;

class FakeTextInput extends TextInput {

    Order readOrder(String order) {
        this.in = new ByteArrayInputStream(order.getBytes());
        return super.readOrder();
    }
}
