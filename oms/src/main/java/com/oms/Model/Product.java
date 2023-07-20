package com.oms.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Product {
    String productId;
    LocalDateTime updateTimeStamp;
    Double quantity;

    public Product(String productId, LocalDateTime updateTimeStamp, Double quantity) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", updateTimeStamp=" + updateTimeStamp +
                ", quantity=" + quantity +
                '}';
    }
}

