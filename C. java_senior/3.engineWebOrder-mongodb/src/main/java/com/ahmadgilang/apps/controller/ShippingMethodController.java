package com.ahmadgilang.apps.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.ShippingMethod;
import com.ahmadgilang.apps.service.ShippingMethodService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shippingMethod")
public class ShippingMethodController {

	@Resource 
	ShippingMethodService shippingMethodService;
	
	@GetMapping(value = "/getAllShippingMethod")
	public Flux<ShippingMethod> getAllShippingMethod() {
		return shippingMethodService.findAll();
	}
	
	@GetMapping(value = "/getById")
	public Mono<ShippingMethod> getById(@RequestParam String id) {
		return shippingMethodService.getById(id);
	}
	
}
