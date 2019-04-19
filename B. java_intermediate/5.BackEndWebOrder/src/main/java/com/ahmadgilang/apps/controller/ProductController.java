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

import com.ahmadgilang.apps.entity.Product;
import com.ahmadgilang.apps.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Resource 
	ProductService productService;
	
	@GetMapping(value = "/getAllProduct")
	public List<Product> getAllProduct() {
		return productService.findAll();
	}
	
	@PostMapping(value = "/saveProduct")
	public void saveProduct(@RequestBody Product product) {
		productService.insertProduct(product);
	}
	@PutMapping(value = "/updateProduct")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	
	@DeleteMapping(value = "/deleteProduct")
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}
	
}
