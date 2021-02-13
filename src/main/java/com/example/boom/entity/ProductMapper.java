/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.entity;

import com.example.boom.entity.model.ProductDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author waichun
 */
@Mapper
@Deprecated
public interface ProductMapper {

    /**
     *
     * get ProductDO by productCode
     * @param productCode
     * @return
     */
    ProductDO getProductDoByProductCode(String productCode);
}
