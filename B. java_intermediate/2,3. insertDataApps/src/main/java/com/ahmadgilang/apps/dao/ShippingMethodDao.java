package com.ahmadgilang.apps.dao;

import java.util.List;

import com.ahmadgilang.apps.entity.ShippingMethod;

public interface ShippingMethodDao {

	public List<ShippingMethod> findAll();
	
	public void insertShippingMethod(ShippingMethod ship);

	public void updateShippingMethod(ShippingMethod ship);

	public void deleteShippingMethod(ShippingMethod ship);
	
	public void truncateShippingMethod();

}
