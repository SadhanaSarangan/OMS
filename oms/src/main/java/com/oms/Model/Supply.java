package com.oms.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Supply {
    String productId;
    LocalDateTime updateTimeStamp;
    Double quantity;
    String status;

    public Supply(String productId, LocalDateTime updateTimeStamp, Double quantity) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "productId='" + productId + '\'' +
                ", updateTimeStamp=" + updateTimeStamp +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
