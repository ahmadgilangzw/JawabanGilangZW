package com.ahmadgilang.apps.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.OrderDetail;
import com.ahmadgilang.apps.service.OrderDetailService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {

	@Resource 
	OrderDetailService orderDetailService;
	
	@GetMapping(value = "/getAllOrderDetail")
	public Flux<OrderDetail> getAllOrder() {
		return orderDetailService.findAll();
	}
	
	@GetMapping(value = "/getByOrderId")
	public Flux<OrderDetail> getByOrderId(@RequestParam String orderId) {
		return orderDetailService.findAllByOrderId(orderId);
	}
	
}
