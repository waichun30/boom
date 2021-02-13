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
public class ProductDO {

    private String productCode;

    private String productName;

    private String productImgPath;

    private String productDescription;

    private String productCurrency;

    private String productAmount;

    private String productStatus;

    private String categoryCode;

    private Date createdTime;

    private Date modifiedTime;

    private String extendInfo;
}
