package com.oms.Service;

import com.oms.Model.Product;
import com.oms.Model.Supply;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyService {
    @Getter
    private static List<Supply> lsSupply = new ArrayList<Supply>();
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss:Z");

    static {

    }

    public Supply getProductSupply(Product product) {
       return lsSupply.stream().filter(supplyDtl -> supplyDtl.getProductId().equalsIgnoreCase(product.getProductId())).findFirst().orElse(null);
    }
}
