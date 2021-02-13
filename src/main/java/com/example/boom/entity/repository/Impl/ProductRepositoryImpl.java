/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.entity.repository.Impl;

import com.example.boom.entity.ProductMapper;
import com.example.boom.entity.model.ProductDO;
import com.example.boom.entity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author waichun
 */
@Deprecated
@Service
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDO getProductByProductCode(String code) {
        return null;
    }
}
