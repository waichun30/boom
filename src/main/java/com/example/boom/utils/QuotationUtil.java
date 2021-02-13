/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author waichun
 */
public class QuotationUtil {

    public static String genQuotationId(){

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        String date = LocalDate.now().format(formatter);

        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replace("-","");

        return date + uuidStr;
    }

}
