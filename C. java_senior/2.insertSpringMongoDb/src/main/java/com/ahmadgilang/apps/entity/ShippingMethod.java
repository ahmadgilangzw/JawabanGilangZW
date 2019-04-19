package com.ahmadgilang.apps.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shipping_methods")
public class ShippingMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5596151309988572411L;

	@Id
	private String _id;
	private String shippingMethod;

	public ShippingMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

}
