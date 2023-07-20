package com.oms.Service;

import com.oms.Model.Order;
import com.oms.Model.Shipment;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ShipmentService {

    @Getter
    private static List<Shipment> lsShipment = new ArrayList<Shipment>();

    static {
        lsShipment.add(new Shipment("Order1", "Ship1", "Prod1",  new Date(2021, 02,19), 2.0));
    }
    public Shipment getShipment(Order order) {
        Predicate<Shipment> shipmentPredicate = shipmentDtl -> shipmentDtl.getOrderId().equalsIgnoreCase(order.getOrderId());
        return lsShipment.stream().filter(shipmentPredicate).findFirst().orElseThrow(RuntimeException::new);
    }
}
