package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.ShippingMethod;

public interface ShippingMethodService {
	
	public List<ShippingMethod> findAll();

	public void readAndInsertShippingMethod(String fileName);
	
}
