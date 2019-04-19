package com.ahmadgilang.apps.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.service.OrderService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Resource 
	OrderService orderService;
	
	@GetMapping(value = "/getAllOrder")
	public Flux<Order> getAllOrder() {
		return orderService.findAll();
	}
	
}
