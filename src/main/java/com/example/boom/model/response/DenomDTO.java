/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.example.boom.model.response;

import com.example.boom.common.DenomEnum;
import lombok.Data;

/**
 * @author waichun
 */
@Data
public class DenomDTO {

    private DenomEnum denom;

    private int quantity;
}
