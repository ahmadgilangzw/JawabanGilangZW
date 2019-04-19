package com.ahmadgilang.apps.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.ShippingMethod;
import com.ahmadgilang.apps.service.ShippingMethodService;

@RestController
@RequestMapping("/shippingMethod")
public class ShippingMethodController {

	@Resource 
	ShippingMethodService shippingMethodService;
	
	@GetMapping(value = "/getAllShippingMethod")
	public List<ShippingMethod> getAllShippingMethod() {
		return shippingMethodService.findAll();
	}
	
	@PostMapping(value = "/saveShippingMethod")
	public void saveShippingMethod(@RequestBody ShippingMethod shippingMethod) {
		shippingMethodService.insertShippingMethod(shippingMethod);
	}
	@PutMapping(value = "/updateShippingMethod")
	public void updateShippingMethod(@RequestBody ShippingMethod shippingMethod) {
		shippingMethodService.updateShippingMethod(shippingMethod);
	}
	
	@DeleteMapping(value = "/deleteShippingMethod")
	public void deleteShippingMethod(@RequestBody ShippingMethod shippingMethod) {
		shippingMethodService.deleteShippingMethod(shippingMethod);
	}
	
}
