package com.oms.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    String orderId;
    String productId;
    Double qty;

    public Order(String orderId, String productId, Double qty) {
        this.orderId = orderId;
        this.productId = productId;
        this.qty = qty;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", qty=" + qty +
                '}';
    }
}
