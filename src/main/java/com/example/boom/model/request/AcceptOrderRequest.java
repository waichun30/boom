package com.example.boom.model.request;

import com.example.boom.common.ActionEnum;
import com.example.boom.common.ProductType;
import com.example.boom.model.base.BaseResult;
import com.example.boom.utils.QuotationUtil;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author waichun
 */
@Data
public class AcceptOrderRequest extends BaseResult {

    @NotNull
    @NumberFormat
    @Min(value = 1)
    private String quantity;

    @NotNull
    private ActionEnum action;

    @NotNull
    private ProductType product;

    private String quotationId = QuotationUtil.genQuotationId();

    public int getQuantity(){
        return Integer.parseInt(quantity);
    }

}
