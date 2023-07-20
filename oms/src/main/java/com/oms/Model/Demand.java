package com.oms.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Demand {

    String productId;
    Double quantity;


    public Demand(String productId, Double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
