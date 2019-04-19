package com.ahmadgilang.apps.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.OrderDetailDao;
import com.ahmadgilang.apps.dao.ProductDao;
import com.ahmadgilang.apps.entity.OrderDetail;
import com.ahmadgilang.apps.service.OrderDetailService;

import reactor.core.publisher.Flux;

@Component
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Resource 
	private OrderDetailDao orderDetailDao;
	
	@Resource
	private ProductDao productDao;
	
	@Override
	public Flux<OrderDetail> findAll() {
		return orderDetailDao.findAll();
	}

	@Override
	public Flux<OrderDetail> findAllByOrderId(String orderId) {
		return orderDetailDao.findAllByOrderId(orderId);
	}

}
