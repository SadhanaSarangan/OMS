package com.oms.Controller;

import com.oms.Model.Product;
import com.oms.Model.Supply;
import com.oms.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class SupplyController {

    @Autowired
    SupplyService supplyService;

    @RequestMapping(value = "/updateSupply", method = RequestMethod.POST)
    public Supply updateSupply(@RequestBody Product product, ModelMap model) {
        Supply supply = supplyService.getProductSupply(product);
        LocalDateTime updateTime = supply.getUpdateTimeStamp();
        LocalDateTime prodUpdateTime = product.getUpdateTimeStamp();
        if (prodUpdateTime.isBefore(updateTime)) {
            supply.setStatus("Out Of Sync");
        } else {
            supply.setQuantity(supply.getQuantity() + product.getQuantity());
        }
        return supply;
    }
}
