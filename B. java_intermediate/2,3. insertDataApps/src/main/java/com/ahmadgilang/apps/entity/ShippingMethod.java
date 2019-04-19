package com.ahmadgilang.apps.entity;

import java.io.Serializable;

public class ShippingMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5596151309988572411L;
	private Long shippingMethodId;
	private String shippingMethod;

	public ShippingMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(Long shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

}
