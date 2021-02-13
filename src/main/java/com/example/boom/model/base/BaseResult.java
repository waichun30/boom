package com.example.boom.model.base;

import lombok.Data;

/**
 * @author waichun
 */
@Data
public class BaseResult extends ExtendedModel{

    private String statusCode;

    private String statusMsg;

}
