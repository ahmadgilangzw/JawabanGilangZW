package com.ahmadgilang.apps.service;

import java.util.List;

import com.ahmadgilang.apps.entity.ShippingMethod;

public interface ShippingMethodService {
	
	public List<ShippingMethod> findAll();

	public void insertShippingMethod(ShippingMethod shippingMethod);

	public void updateShippingMethod(ShippingMethod shippingMethod);

	public void deleteShippingMethod(ShippingMethod shippingMethod);
	
	public void truncateShippingMethod();
	
	public void readAndInsertShippingMethod(String fileName);
	
}
