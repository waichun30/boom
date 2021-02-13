/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.helper;

import com.example.boom.logging.Loggers;
import com.example.boom.logging.LoggingUtil;
import com.example.boom.model.response.AcceptOrderResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author waichun
 * Since we are not using database, we use a hashmap to maintain order
 */
@Component
@Getter
public class OrderAccumulator {

    private final Map<String, String> orderMap = new HashMap<>();

    public void updateOrder(AcceptOrderResponse response) {
        orderMap.put(response.getQuotationId(), response.getOrderAmount());
        LoggingUtil.info(Loggers.BIZ_SERVICE, this.getClass().getSimpleName() + " Update Order: " + response.getQuotationId() + " Amount: " + response.getOrderAmount());
    }

    public BigDecimal getOrder(String quotationId) {
        String amount = orderMap.get(quotationId);
        return amount == null ? new BigDecimal(0) : new BigDecimal(amount);
    }

    public void removeOrder(String quotationId) {
        orderMap.remove(quotationId);
        LoggingUtil.info(Loggers.BIZ_SERVICE, this.getClass().getSimpleName() + " Remove Order: " + quotationId);
    }
}
