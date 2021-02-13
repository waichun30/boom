/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service.impl;

import com.example.boom.common.DenomEnum;
import com.example.boom.common.StatusCode;
import com.example.boom.helper.OrderAccumulator;
import com.example.boom.logging.Loggers;
import com.example.boom.logging.LoggingUtil;
import com.example.boom.model.request.PaymentOrderRequest;
import com.example.boom.model.response.DenomDTO;
import com.example.boom.model.response.PaymentOrderResponse;
import com.example.boom.service.PaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * @author waichun
 */
@Component
public class PaymentOrderServiceImpl implements PaymentOrderService {

    @Autowired
    private OrderAccumulator orderAccumulator;

    @Override
    public PaymentOrderResponse paymentOrder(PaymentOrderRequest paymentOrderRequest) {
        PaymentOrderResponse response = new PaymentOrderResponse();

        BigDecimal orderAmount = orderAccumulator.getOrder(paymentOrderRequest.getQuotationId());
        BigDecimal payAmount = paymentOrderRequest.getPayAmount();

        if (orderAmount.equals(new BigDecimal(0))) {
            response.setStatusCodeEnum(StatusCode.ORDER_NOT_FOUND);
            return response;
        } else if (orderAmount.compareTo(payAmount) > 0) {
            response.setStatusCodeEnum(StatusCode.INSUFFICIENT_AMOUNT);
            LoggingUtil.info(Loggers.BIZ_SERVICE, this.getClass().getSimpleName() + " Receive Payment Less Than Order Amount - " + payAmount + ", " + orderAmount);
            return response;
        }

        BigDecimal changeAmount = payAmount.subtract(orderAmount);
        int changeAmountInt = changeAmount.intValue();
        String changeAmountStr = changeAmount.toPlainString();

        int one, ten, oneHundred, fiveHundred, oneThousand, fiveThousand;
        List<DenomDTO> denomDTOList = new ArrayList<>();

        fiveThousand = changeAmountInt / DenomEnum.FIVE_THOUSAND.getAmount();
        changeAmountInt = changeAmountInt - fiveThousand * DenomEnum.FIVE_THOUSAND.getAmount();
        DenomDTO fiveThousandDenom = new DenomDTO();
        fiveThousandDenom.setDenom(DenomEnum.FIVE_THOUSAND);
        fiveThousandDenom.setQuantity(fiveThousand);
        denomDTOList.add(fiveThousandDenom);

        oneThousand = changeAmountInt / DenomEnum.ONE_THOUSAND.getAmount();
        changeAmountInt = changeAmountInt - oneThousand * DenomEnum.ONE_THOUSAND.getAmount();
        DenomDTO oneThousandDenom = new DenomDTO();
        oneThousandDenom.setDenom(DenomEnum.ONE_THOUSAND);
        oneThousandDenom.setQuantity(oneThousand);
        denomDTOList.add(oneThousandDenom);

        fiveHundred = changeAmountInt / DenomEnum.FIVE_HUNDRED.getAmount();
        changeAmountInt = changeAmountInt - fiveHundred * DenomEnum.FIVE_HUNDRED.getAmount();
        DenomDTO fiveHundredDenom = new DenomDTO();
        fiveHundredDenom.setDenom(DenomEnum.FIVE_HUNDRED);
        fiveHundredDenom.setQuantity(fiveHundred);
        denomDTOList.add(fiveHundredDenom);

        oneHundred = changeAmountInt / DenomEnum.ONE_HUNDRED.getAmount();
        changeAmountInt = changeAmountInt - oneHundred * DenomEnum.ONE_HUNDRED.getAmount();
        DenomDTO oneHundredDenom = new DenomDTO();
        oneHundredDenom.setDenom(DenomEnum.ONE_HUNDRED);
        oneHundredDenom.setQuantity(oneHundred);
        denomDTOList.add(oneHundredDenom);

        ten = changeAmountInt / DenomEnum.TEN.getAmount();
        changeAmountInt = changeAmountInt - ten * DenomEnum.TEN.getAmount();
        DenomDTO tenDenom = new DenomDTO();
        tenDenom.setDenom(DenomEnum.TEN);
        tenDenom.setQuantity(ten);
        denomDTOList.add(tenDenom);

        one = changeAmountInt;
        DenomDTO oneDenom = new DenomDTO();
        oneDenom.setDenom(DenomEnum.ONE);
        oneDenom.setQuantity(one);
        denomDTOList.add(oneDenom);

        response.setChangeAmount(changeAmountStr);
        response.setDenomDTOList(denomDTOList);
        response.setStatusCodeEnum(StatusCode.OK);

        orderAccumulator.removeOrder(paymentOrderRequest.getQuotationId());
        LoggingUtil.info(Loggers.BIZ_SERVICE, this.getClass().getSimpleName() + " Transaction Complete: " + paymentOrderRequest.getQuotationId());

        return response;
    }

}
