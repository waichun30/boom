/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * The enum Product type.
 *
 * @author waichun
 */
public enum ProductType {

    /**
     * The Scan.
     */
    SCAN("SCAN", new BigDecimal("100"), TxnType.FACILITIES, "scan"),

    /**
     * The Print black white.
     */
    PRINT_BLACK_WHITE("PRINT_BLACK_WHITE", new BigDecimal("50"),TxnType.FACILITIES, "print black and white"),

    /**
     * The Print color.
     */
    PRINT_COLOR("PRINT_COLOR", new BigDecimal("80"), TxnType.FACILITIES, "print color"),

    /**
     * The Drink.
     */
    DRINK("DRINK", new BigDecimal("150"),TxnType.FACILITIES,  "drink"),

    /**
     * The Browsing.
     */
    BROWSING("BROWSING",new BigDecimal("200"),TxnType.USAGE, "browsing"),

    /**
     * The Typing.
     */
    TYPING("TYPING",new BigDecimal("100"),TxnType.USAGE, "typing"),

    /**
     * The Gaming.
     */
    GAMING("GAMING",new BigDecimal("300"),TxnType.USAGE, "gaming");

    private final String code;
    private final BigDecimal price;
    private final TxnType txnType;
    private final String desc;

    ProductType(String code, BigDecimal price, TxnType txnType, String desc){
        this.code = code;
        this.price = price;
        this.txnType = txnType;
        this.desc = desc;
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
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Gets txn type.
     *
     * @return the txn type
     */
    public TxnType getTxnType() {
        return txnType;
    }

    private final static Map<String, ProductType> map = new HashMap<>();

    static {
        for(ProductType value : values()){
            map.put(value.getCode(), value);
        }
    }

    /**
     * Get product product type.
     *
     * @param code the code
     * @return the product type
     */
    public static ProductType getProduct(String code){
        return map.get(code);
    }

}
