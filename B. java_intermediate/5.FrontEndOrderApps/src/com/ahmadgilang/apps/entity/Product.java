/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.entity;

import java.math.BigDecimal;

/**
 *
 * @author asus
 */
public class Product {
/**
* 
*/
private static final long serialVersionUID = -5596151309988572411L;
private Long productId;
private String productName;
private BigDecimal unitPrice;
private String inStock;

public Product() {
       super();
       // TODO Auto-generated constructor stub
}

public Long getProductId() {
       return productId;
}

public void setProductId(Long productId) {
       this.productId = productId;
}

public String getProductName() {
       return productName;
}

public void setProductName(String productName) {
       this.productName = productName;
}

public BigDecimal getUnitPrice() {
       return unitPrice;
}

public void setUnitPrice(BigDecimal unitPrice) {
       this.unitPrice = unitPrice;
}

public String getInStock() {
       return inStock;
}

public void setInStock(String inStock) {
       this.inStock = inStock;
}
}
