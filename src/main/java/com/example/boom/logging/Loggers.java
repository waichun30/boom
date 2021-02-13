/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author waichun
 */
public abstract class Loggers {

    public static final Logger BOOT_LOGGER = LoggerFactory.getLogger("SERVER_BOOT");

    public static final Logger BIZ_SERVICE = LoggerFactory.getLogger("BIZ_SERVICE");

    public static final Logger BIZ_HTTP = LoggerFactory.getLogger("BIZ_HTTP");

}