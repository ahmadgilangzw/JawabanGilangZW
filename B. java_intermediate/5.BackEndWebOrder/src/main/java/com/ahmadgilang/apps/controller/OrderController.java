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

import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Resource 
	OrderService orderService;
	
	@GetMapping(value = "/getAllOrder")
	public List<Order> getAllOrder() {
		return orderService.findAll();
	}
	
	@PostMapping(value = "/saveOrder")
	public void saveOrder(@RequestBody Order order) {
		orderService.insertOrder(order);
	}
	@PutMapping(value = "/updateOrder")
	public void updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
	}
	
	@DeleteMapping(value = "/deleteOrder")
	public void deleteOrder(@RequestBody Order order) {
		orderService.deleteOrder(order);
	}
	
}
