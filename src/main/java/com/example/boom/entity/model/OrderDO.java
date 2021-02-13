/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.entity.model;

import lombok.Data;

import java.util.Date;

/**
 * @author waichun
 */
@Data
@Deprecated
public class OrderDO {

    private String orderCode;

    private String merchantCode;

    private String qrCode;

    private int amount;

    private String orderStatus;

    private Date createdTime;

    private Date modifiedTime;

    private String extendInfo;

}
