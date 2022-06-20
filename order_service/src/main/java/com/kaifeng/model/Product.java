package com.kaifeng.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Long id;

    private int status;

    private String productName;

    private BigDecimal price;

    private String productDesc;

    private String caption;

    private Integer inventory;

}
