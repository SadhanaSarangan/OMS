package com.oms.Controller;

import com.oms.Model.Demand;
import com.oms.Model.Product;
import com.oms.Model.Supply;
import com.oms.Service.SupplyService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class SupplyController {

    @Autowired
    SupplyService supplyService;

    @RequestMapping(value="/getAvailability", method = RequestMethod.GET)
    public Product getAvailability(@RequestBody Product product, HttpServletResponse response, ModelMap model) {
        Supply supply = supplyService.getSupply(product);
        Demand demand = supplyService.getDemand(product);
        double quantity = supply.getQuantity() - demand.getQuantity();
        if (quantity <= 0 ){
            response.setStatus( HttpStatus.NO_CONTENT.value());
        } else {
            product.setStatus("Available");
        }
        return product;
    }

    @RequestMapping(value = "/updateSupply", method = RequestMethod.POST)
    public Supply updateSupply(@RequestBody Product product, ModelMap model) throws ParseException {
        Supply supply = supplyService.getProductSupply(product);
        LocalDateTime updateTime = supply.getUpdateTimeStamp();
        LocalDateTime prodUpdateTime = product.getUpdateTimeStamp();
        if (prodUpdateTime.isBefore(updateTime)) {
            supply.setStatus("Out Of Sync");
        } else {
            supply.setQuantity(supply.getQuantity() + product.getQuantity());
            supply.setStatus("Updated");
        }
        return supply;
    }
}
