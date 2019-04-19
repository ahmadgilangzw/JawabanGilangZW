package com.ahmadgilang.apps.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1411306150030503726L;
	private Long orderId;
	private Long customerId;
	private Long employeeId;
	private Date orderDate;
	private String purchaseOrderNumber;
	private Date shipDate;
	private Long shippingMethodId;
	private BigDecimal freightCharge;
	private BigDecimal taxes;
	private String paymentReceived;
	private String comment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Long getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(Long shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public BigDecimal getFreightCharge() {
		return freightCharge;
	}

	public void setFreightCharge(BigDecimal freightCharge) {
		this.freightCharge = freightCharge;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	public String getPaymentReceived() {
		return paymentReceived;
	}

	public void setPaymentReceived(String paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
