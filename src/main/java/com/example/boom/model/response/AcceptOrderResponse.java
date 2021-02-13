package com.example.boom.model.response;

import com.example.boom.common.StatusCode;
import com.example.boom.model.base.BaseResult;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author waichun
 */
@Getter
@Setter
@ToString(callSuper = true)
public class AcceptOrderResponse extends BaseResult {

    private String quotationId;

    private String orderAmount;

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = String.valueOf(orderAmount);
    }

    public void setStatusCodeEnum(StatusCode statusCode) {
        this.setStatusMsg(statusCode.getMsg());
        this.setStatusCode(statusCode.getCode());
    }
}
