/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.service;

import com.example.boom.common.TxnType;
import com.example.boom.service.impl.DefaultCalculateProcessorImpl;
import com.example.boom.service.impl.FacilitiesCalculateProcessorImpl;
import com.example.boom.service.impl.UsageCalculateProcessorImpl;
import com.example.boom.service.Qualifier.CalculateOrderQualifier;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author waichun
 */
@Component
public class CalculateOrderProcessorFactory implements InitializingBean {


    private final HashMap<TxnType, CalculateOrderProcessor> calculateOrderProcessorHashMap = new HashMap<>();

    @Autowired
    @CalculateOrderQualifier(txnType = TxnType.FACILITIES)
    private FacilitiesCalculateProcessorImpl calculateFacilitiesProcessor;

    @Autowired
    @CalculateOrderQualifier(txnType = TxnType.USAGE)
    private UsageCalculateProcessorImpl calculateUsageProcessor;

    @Autowired
    private DefaultCalculateProcessorImpl defaultCalculateProcessor;


    @Override
    public void afterPropertiesSet() {
        calculateOrderProcessorHashMap.put(TxnType.FACILITIES, calculateFacilitiesProcessor);
        calculateOrderProcessorHashMap.put(TxnType.USAGE, calculateUsageProcessor);
    }


    public CalculateOrderProcessor getCalculateOrderProcessor(TxnType txnType) {
        CalculateOrderProcessor processor = calculateOrderProcessorHashMap.get(txnType);

        if (processor == null) {
            return defaultCalculateProcessor;
        }
        return processor;
    }

}
