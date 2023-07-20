package com.oms.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Shipment {
    String orderId;
    String shipmentId;
    String productId;
    Date shipmentDate;
    Double qty;


    public Shipment(String orderId, String shipmentId, String productId, Date shipmentDate, Double qty) {
        this.orderId = orderId;
        this.shipmentId = shipmentId;
        this.productId = productId;
        this.shipmentDate = shipmentDate;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "orderId='" + orderId + '\'' +
                ", shipmentId='" + shipmentId + '\'' +
                ", productId='" + productId + '\'' +
                ", shipmentDate=" + shipmentDate +
                ", qty=" + qty +
                '}';
    }
}
