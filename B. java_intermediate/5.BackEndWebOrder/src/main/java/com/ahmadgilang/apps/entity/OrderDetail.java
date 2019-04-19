package com.ahmadgilang.apps.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7682235781770217522L;
	private Long orderDetailId;
	private Long orderId;
	private Long productId;
	private Long quantity;
	private BigDecimal unitPrice;
	private BigDecimal discount;

	private Product product;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
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
