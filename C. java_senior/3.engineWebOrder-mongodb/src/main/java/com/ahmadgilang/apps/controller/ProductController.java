package com.ahmadgilang.apps.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmadgilang.apps.entity.Product;
import com.ahmadgilang.apps.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Resource 
	ProductService productService;
	
	@GetMapping(value = "/getAllProduct")
	public Flux<Product> getAllProduct() {
		return productService.findAll();
	}
	
	@GetMapping(value = "/getById")
	public Mono<Product> getById(@RequestParam String id) {
		return productService.getById(id);
	}
	
}
