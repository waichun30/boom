package com.example.boom.controller;

import com.example.boom.controller.base.AbstractController;
import com.example.boom.model.request.PaymentOrderRequest;
import com.example.boom.model.response.PaymentOrderResponse;
import com.example.boom.service.PaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author waichun
 * This controller will make payment to the order
 */
@RestController
public class PaymentOrderController extends AbstractController {


    @Autowired
    private PaymentOrderService paymentOrderService;

    @PostMapping(value = "/1.0/payment/order")
    public <T> T paymentOrder(@RequestBody @Validated PaymentOrderRequest request) {
        return processRequest(request);
    }

    @Override
    protected <T> T doService(T o) {
        PaymentOrderRequest request = (PaymentOrderRequest) o;
        PaymentOrderResponse response = paymentOrderService.paymentOrder(request);
        return (T) response;
    }
}
