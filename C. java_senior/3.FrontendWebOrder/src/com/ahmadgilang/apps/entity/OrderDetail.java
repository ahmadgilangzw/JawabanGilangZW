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
public class OrderDetail {
/**
* 
*/
private static final long serialVersionUID = 7682235781770217522L;

private String _id;
private String orderId;
private String productId;
private Long quantity;
private BigDecimal unitPrice;
private BigDecimal discount;

private Product product;

public OrderDetail() {
       super();
       // TODO Auto-generated constructor stub
}

public String get_id() {
        return _id;
}

public void set_id(String _id) {
        this._id = _id;
}

public String getOrderId() {
       return orderId;
}

public void setOrderId(String orderId) {
       this.orderId = orderId;
}

public String getProductId() {
       return productId;
}

public void setProductId(String productId) {
       this.productId = productId;
}

public Long getQuantity() {
       return quantity;
}

public void setQuantity(Long quantity) {
       this.quantity = quantity;
}

public BigDecimal getUnitPrice() {
       return unitPrice;
}

public void setUnitPrice(BigDecimal unitPrice) {
       this.unitPrice = unitPrice;
}

public BigDecimal getDiscount() {
       return discount;
}

public void setDiscount(BigDecimal discount) {
       this.discount = discount;
}

public Product getProduct() {
       return product;
}

public void setProduct(Product product) {
       this.product = product;
}
}
