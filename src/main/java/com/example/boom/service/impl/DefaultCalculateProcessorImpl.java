/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service.impl;

import com.example.boom.common.StatusCode;
import com.example.boom.helper.OrderAccumulator;
import com.example.boom.model.request.AcceptOrderRequest;
import com.example.boom.model.response.AcceptOrderResponse;
import com.example.boom.service.AbstractCalculateService;
import com.example.boom.service.CalculateOrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author waichun
 */
@Component
public class DefaultCalculateProcessorImpl extends AbstractCalculateService implements CalculateOrderProcessor {

    @Autowired
    private OrderAccumulator orderAccumulator;

    @Override
    public AcceptOrderResponse calculateOrder(AcceptOrderRequest acceptOrderRequest) {
        AcceptOrderResponse response = new AcceptOrderResponse();
        response.setOrderAmount(orderAccumulator.getOrder(acceptOrderRequest.getQuotationId()));
        response.setQuotationId(acceptOrderRequest.getQuotationId());
        return response;
    }

    @Override
    protected StatusCode validateRequest(AcceptOrderRequest acceptOrderRequest) {
        return StatusCode.OK;
    }
}
