package com.example.boom.common;

/**
 * The enum Status code.
 *
 * @author waichun
 */
public enum StatusCode {

    /**
     * Ok status code.
     */
    OK("0000", "OK"),
    /**
     * The Invalid quantity.
     */
    INVALID_QUANTITY("2001", "Invalid Quantity"),
    /**
     * The Invalid product.
     */
    INVALID_PRODUCT("2002", "Invalid Product"),
    /**
     * The Invalid order.
     */
    INVALID_ORDER("2003", "Invalid Order"),
    /**
     * The Order not found.
     */
    ORDER_NOT_FOUND("2004", "Order Not Found"),
    /**
     * The Insufficient amount.
     */
    INSUFFICIENT_AMOUNT("2005", "Insufficient Amount");

    private String code;
    private String msg;

    StatusCode(String code, String msg){
        this.code = code;
        this.msg = msg;
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
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
}
