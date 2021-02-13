/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service.impl;

import com.example.boom.common.StatusCode;
import com.example.boom.common.TxnType;
import com.example.boom.model.request.AcceptOrderRequest;
import com.example.boom.model.response.AcceptOrderResponse;
import com.example.boom.service.AbstractCalculateService;
import com.example.boom.service.CalculateOrderProcessor;
import com.example.boom.service.Qualifier.CalculateOrderQualifier;
import org.springframework.stereotype.Component;

/**
 * @author waichun
 */
@Component
@CalculateOrderQualifier(txnType = TxnType.USAGE)
public class UsageCalculateProcessorImpl extends AbstractCalculateService implements CalculateOrderProcessor {

    @Override
    public AcceptOrderResponse calculateOrder(AcceptOrderRequest acceptOrderRequest) {
        return processOrder(acceptOrderRequest);
    }

    @Override
    protected StatusCode validateRequest(AcceptOrderRequest acceptOrderRequest) {
        return baseValidateRequest(acceptOrderRequest);
    }
}

