package com.example.boom.model.request;

import com.example.boom.model.base.ExtendedModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author waichun
 */
@Data
public class PaymentOrderRequest extends ExtendedModel {

    @NotBlank
    private String payAmount;

    @NotBlank
    private String quotationId;

    public BigDecimal getPayAmount(){
        return new BigDecimal(payAmount);
    }

}
