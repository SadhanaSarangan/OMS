package com.oms.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderShipment {
    Order order;
    Shipment shipment;

    public OrderShipment(Order order, Shipment shipment) {
        this.order = order;
        this.shipment = shipment;
    }

    @Override
    public String toString() {
        return "OrderShipment{" +
                "order=" + order +
                ", shipment=" + shipment +
                '}';
    }
}
