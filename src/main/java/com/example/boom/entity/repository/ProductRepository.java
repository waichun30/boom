/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.entity.repository;

import com.example.boom.entity.model.ProductDO;

/**
 * @author waichun
 */
@Deprecated
public interface ProductRepository {

    ProductDO getProductByProductCode(String code);

}