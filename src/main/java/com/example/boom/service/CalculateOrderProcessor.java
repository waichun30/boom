/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service;

import com.example.boom.model.request.AcceptOrderRequest;
import com.example.boom.model.response.AcceptOrderResponse;

/**
 * @author waichun
 */
public interface CalculateOrderProcessor {

    /**
     * calculate order
     * @param acceptOrderRequest
     * @return
     */
    AcceptOrderResponse calculateOrder(AcceptOrderRequest acceptOrderRequest);

}