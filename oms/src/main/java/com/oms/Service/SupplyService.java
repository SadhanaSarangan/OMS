package com.oms.Service;

import com.oms.Model.Demand;
import com.oms.Model.Product;
import com.oms.Model.Supply;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplyService {
    @Getter
    private static List<Supply> lsSupply1 = new ArrayList<Supply>();
    private static List<Supply> lsSupply = new ArrayList<Supply>();
    private static List<Demand> lsDemand = new ArrayList<Demand>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static {
        lsSupply.add(new Supply("Product1",10.0));
        lsSupply.add(new Supply("Product2",5.0));
        lsDemand.add(new Demand("Product1",2.0));
        lsDemand.add(new Demand("Product2",5.0));
    }

    public Supply getSupply(Product product) {
        return lsSupply.stream().filter(supply -> supply.getProductId().equalsIgnoreCase(product.getProductId())).findFirst().orElse(null);
    }

    public Demand getDemand(Product product) {
        return lsDemand.stream().filter(demand -> demand.getProductId().equalsIgnoreCase(product.getProductId())).findFirst().orElse(null);
    }

    public Supply getProductSupply(Product product) throws ParseException {
        lsSupply1.add(new Supply("Product1",LocalDateTime.of(2021, Month.MARCH,16,8,53,48,616) , 10.0));
        lsSupply1.add(new Supply("Product2",LocalDateTime.of(2021, Month.MARCH,16,8,59,48,616), 5.0));
        lsSupply1.add(new Supply("Product3",LocalDateTime.of(2021, Month.MARCH,16,9,10,48,616) , 30.0));
        lsSupply1.add(new Supply("Product4",LocalDateTime.of(2021, Month.MARCH,16,9,10,48,616) , 20.0));
       return lsSupply1.stream().filter(supplyDtl -> supplyDtl.getProductId().equalsIgnoreCase(product.getProductId())).findFirst().orElse(null);
    }
}
