package com.oms.Service;

import com.oms.Model.Order;
import com.oms.Model.OrderShipment;
import com.oms.Model.Shipment;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class OrderService {

    @Getter
    private static List<Order> lsOrder = new ArrayList<Order>();

    static {
        lsOrder.add(new Order("Order1", "Prod1", 2.0));
    }

    public Order getOrder(Order order) {
        return lsOrder.stream().filter(orderDtl -> orderDtl.getOrderId().equalsIgnoreCase(order.getOrderId())).findFirst().orElse(null);
    }
}
