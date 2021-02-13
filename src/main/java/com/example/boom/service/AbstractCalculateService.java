/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service;

import com.example.boom.common.ActionEnum;
import com.example.boom.common.ProductType;
import com.example.boom.common.StatusCode;
import com.example.boom.helper.OrderAccumulator;
import com.example.boom.logging.Loggers;
import com.example.boom.logging.LoggingUtil;
import com.example.boom.model.request.AcceptOrderRequest;
import com.example.boom.model.response.AcceptOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author waichun
 */
public abstract class AbstractCalculateService {

    @Autowired
    private OrderAccumulator orderAccumulator;

    protected AcceptOrderResponse processOrder(AcceptOrderRequest acceptOrderRequest) {

        LoggingUtil.info(Loggers.BIZ_SERVICE, this.getClass().getSimpleName() + " Processing Order: "+ acceptOrderRequest.getQuotationId());

        AcceptOrderResponse acceptOrderResponse = new AcceptOrderResponse();

        StatusCode statusCode = validateRequest(acceptOrderRequest);

        if (statusCode != StatusCode.OK) {
            acceptOrderResponse.setStatusCodeEnum(statusCode);
            return acceptOrderResponse;
        }

        ProductType orderProduct = acceptOrderRequest.getProduct();

        BigDecimal currentFee = orderAccumulator.getOrder(acceptOrderRequest.getQuotationId());
        BigDecimal orderQuantity = BigDecimal.valueOf(acceptOrderRequest.getQuantity()).divide(BigDecimal.valueOf(orderProduct.getTxnType().getQuantity()));
        BigDecimal productOrderAmt = orderProduct.getPrice().multiply(orderQuantity);
        BigDecimal newOrderAmt;

        if (ActionEnum.ADD.equals(acceptOrderRequest.getAction())) {
            newOrderAmt = addOrder(currentFee, productOrderAmt);
        } else {
            if (productOrderAmt.compareTo(currentFee) > 0) {
                acceptOrderResponse.setQuotationId(acceptOrderRequest.getQuotationId());
                acceptOrderResponse.setStatusCodeEnum(StatusCode.INVALID_ORDER);
                acceptOrderResponse.setExtendInfo(acceptOrderRequest.getExtendInfo());
                return acceptOrderResponse;
            }
            newOrderAmt = removeOrder(currentFee, productOrderAmt);
        }

        acceptOrderResponse.setOrderAmount(newOrderAmt);
        acceptOrderResponse.setQuotationId(acceptOrderRequest.getQuotationId());
        acceptOrderResponse.setStatusCodeEnum(StatusCode.OK);
        acceptOrderResponse.setExtendInfo(acceptOrderRequest.getExtendInfo());

        return acceptOrderResponse;

    }


    private BigDecimal addOrder(BigDecimal currentFee, BigDecimal productOrderAmt) {
        return currentFee.add(productOrderAmt);
    }

    private BigDecimal removeOrder(BigDecimal currentFee, BigDecimal productOrderAmt) {
        return currentFee.subtract(productOrderAmt);
    }

    protected StatusCode baseValidateRequest(AcceptOrderRequest acceptOrderRequest) {
        int quantity = acceptOrderRequest.getQuantity();

        int minOrderQuantity = acceptOrderRequest.getProduct().getTxnType().getQuantity();

        if (quantity % minOrderQuantity != 0) {
            return StatusCode.INVALID_QUANTITY;
        }

        return StatusCode.OK;
    }


    protected abstract StatusCode validateRequest(AcceptOrderRequest acceptOrderRequest);


}
