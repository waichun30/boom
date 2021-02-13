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
public class OrderProductDO {

    private String orderProductCode;

    private String orderCode;

    private String productCode;

    private String quantity;

    private String memo;

    private Date createdTime;

    private Date modifiedTime;

    private String extendInfo;

}
