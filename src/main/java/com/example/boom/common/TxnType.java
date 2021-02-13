/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.common;

/**
 * The enum Txn type.
 *
 * @author waichun
 */
public enum TxnType {

    /**
     * Usage txn type.
     */
    USAGE("USAGE", 30),
    /**
     * Facilities txn type.
     */
    FACILITIES("FACILITIES", 1);


    private final String code;

    private final int quantity;


    TxnType(String code, int quantity) {
        this.code = code;
        this.quantity = quantity;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
