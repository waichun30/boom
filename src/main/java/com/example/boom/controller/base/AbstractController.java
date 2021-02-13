/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.controller.base;

import com.example.boom.logging.Loggers;
import com.example.boom.logging.LoggingUtil;

/**
 * @author waichun
 */
public abstract class AbstractController {

    protected <T> T processRequest(Object o) {
        LoggingUtil.info(Loggers.BIZ_HTTP, this.getClass().getSimpleName() + "Request - " + o);
        T response = (T) doService(o);
        LoggingUtil.info(Loggers.BIZ_HTTP, this.getClass().getSimpleName() + "Response - " + response);
        return response;
    }

    /**
     * Apply all business logic over here
     *
     * @param o
     * @return
     */
    protected abstract <T> T doService(T o);
}
