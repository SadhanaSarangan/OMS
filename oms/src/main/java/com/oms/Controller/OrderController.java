package com.oms.Controller;

import com.oms.Model.Order;
import com.oms.Model.OrderShipment;
import com.oms.Model.Shipment;
import com.oms.Service.OrderService;
import com.oms.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShipmentService shipmentService;
    @RequestMapping(value = "/getOrderDetails", method = RequestMethod.GET)
    public OrderShipment getOrderDetails(@RequestBody Order order, ModelMap model) throws ExecutionException, InterruptedException {
       // String orderId = order.getOrderId();
        System.out.println(order);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future orderDetails = executorService.submit(getOrder(order, orderService));
        Future shipmentDetails = executorService.submit(getShipment(order, shipmentService));
        executorService.shutdown();
        Order orderDtl = (Order) orderDetails.get();
        Shipment shipmentDtl = (Shipment) shipmentDetails.get();
        OrderShipment orderShipment = new OrderShipment(orderDtl, shipmentDtl);
        return orderShipment;
    }

    private Callable getShipment(Order order, ShipmentService shipmentService) {
        return new Callable() {

            @Override
            public Object call() throws Exception {
                return shipmentService.getShipment(order);
            }
        };
    }

    private Callable getOrder(Order order, OrderService orderService) {
        return new Callable() {

            @Override
            public Object call() throws Exception {
                return orderService.getOrder(order);
            }
        };
    }
}
