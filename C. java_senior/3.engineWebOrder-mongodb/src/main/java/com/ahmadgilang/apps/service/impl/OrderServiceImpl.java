package com.ahmadgilang.apps.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.OrderDao;
import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.service.OrderService;

import reactor.core.publisher.Flux;

@Component
public class OrderServiceImpl implements OrderService{
	
	@Resource 
	private OrderDao orderDao;
	
	@Override
	public Flux<Order> findAll() {
		Flux<Order> listOder = orderDao.findAll();
		return listOder;
	}
	
}
