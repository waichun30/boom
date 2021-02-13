package com.example.boom.controller;

import com.example.boom.common.StatusCode;
import com.example.boom.controller.base.AbstractController;
import com.example.boom.helper.OrderAccumulator;
import com.example.boom.model.request.AcceptOrderRequest;
import com.example.boom.model.response.AcceptOrderResponse;
import com.example.boom.service.CalculateOrderProcessor;
import com.example.boom.service.CalculateOrderProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author waichun
 * This controller will update the order
 */
@RestController
public class AcceptOrderController extends AbstractController {

    @Autowired
    private CalculateOrderProcessorFactory calculateOrderProcessorFactory;

    @Autowired
    private OrderAccumulator orderAccumulator;

    @PostMapping(value = "/1.0/accept/order")
    public <T> T acceptOrder(@RequestBody @Validated AcceptOrderRequest request) {
        return processRequest(request);
    }

    @Override
    protected <T> T doService(T o) {
        AcceptOrderRequest request = (AcceptOrderRequest) o;
        CalculateOrderProcessor processor = calculateOrderProcessorFactory.getCalculateOrderProcessor(request.getProduct().getTxnType());
        AcceptOrderResponse response = processor.calculateOrder(request);
        if (StatusCode.OK.getCode().equals(response.getStatusCode())) {
            orderAccumulator.updateOrder(response);
        }
        return (T) response;
    }

}
