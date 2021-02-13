/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service;

import com.example.boom.model.request.PaymentOrderRequest;
import com.example.boom.model.response.PaymentOrderResponse;
import org.springframework.stereotype.Service;

/**
 * @author waichun
 */
@Service
public interface PaymentOrderService {
    /**
     * Make payment
     * @param paymentOrderRequest
     * @return
     */
    PaymentOrderResponse paymentOrder(PaymentOrderRequest paymentOrderRequest);
}
