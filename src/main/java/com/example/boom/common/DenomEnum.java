package com.example.boom.common;

import java.util.HashMap;
import java.util.Map;

/**
 * denom in cent
 *
 * @author waichun
 */
public enum DenomEnum {

    /**
     * One denom enum.
     */
    ONE("ONE", 1),

    /**
     * Ten denom enum.
     */
    TEN("TEN", 10),

    /**
     * One hundred denom enum.
     */
    ONE_HUNDRED("ONE_HUNDRED", 100),

    /**
     * Five hundred denom enum.
     */
    FIVE_HUNDRED("FIVE_HUNDRED", 500),

    /**
     * One thousand denom enum.
     */
    ONE_THOUSAND("ONE_THOUSAND", 1000),

    /**
     * Five thousand denom enum.
     */
    FIVE_THOUSAND("FIVE_THOUSAND", 5000);

    private String code;

    private int amount;

    DenomEnum(String code, int amount) {
        this.code = code;
        this.amount = amount;
    }

    private static final Map<String, DenomEnum> map = new HashMap<>();

    static {
        for (DenomEnum value : values()) {
            map.put(value.getCode(), value);
        }
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
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Gets denom enum by code.
     *
     * @param code the code
     * @return the denom enum by code
     */
    public static DenomEnum getDenomEnumByCode(String code) {
        return map.get(code);
    }}
