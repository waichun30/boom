package com.example.boom.model.response;

import com.example.boom.common.StatusCode;
import com.example.boom.model.base.BaseResult;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author waichun
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PaymentOrderResponse extends BaseResult {

    private String changeAmount;

    private List<DenomDTO> denomDTOList;

    public void setStatusCodeEnum(StatusCode statusCode) {
        this.setStatusMsg(statusCode.getMsg());
        this.setStatusCode(statusCode.getCode());
    }
}
