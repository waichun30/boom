/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * @author waichun
 */
@Slf4j
public class LoggingUtil {

    private static Logger unWrapperLogger(Logger logger) {
        Logger result = logger;
        return result;
    }

    public static void info(Logger logger, String message) {
        Logger unwrapperLogger = unWrapperLogger(logger);
        if (unwrapperLogger.isInfoEnabled()) {
            unwrapperLogger.info(message);
        }
    }

    public static void info(Logger logger, String template, Object... messages) {
        Logger unwrapperLogger = unWrapperLogger(logger);
        if (unwrapperLogger.isInfoEnabled()) {
            unwrapperLogger.info(template, messages);
        }
    }

}
