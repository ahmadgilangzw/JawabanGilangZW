package com.ahmadgilang.apps.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.ProductDao;
import com.ahmadgilang.apps.entity.Product;
import com.ahmadgilang.apps.service.ProductService;
import com.ahmadgilang.apps.utils.EngineUtils;

@Component
public class ProductServiceImpl implements ProductService{
	
	private static Logger logger = Logger.getLogger(ProductServiceImpl.class.getCanonicalName());
	
	@Resource 
	ProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}
	
	@Override
	public void insertProduct(Product emp) {
		productDao.insertProduct(emp);
		
	}
	
	@Override
	public void updateProduct(Product emp) {
		productDao.updateProduct(emp);
	}

	@Override
	public void deleteProduct(Product emp) {
		productDao.deleteProduct(emp);
		
	}

	@Override
	public void truncateProduct() {
		productDao.truncateProduct();
	}

	@Override
	public void readAndInsertProduct(String fileName) {
		try{
			productDao.truncateProduct();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					Product product = new Product();
					product.setProductId(Long.parseLong(line[0]));
					product.setProductName(line[1]);
					product.setUnitPrice(new BigDecimal(line[2].replace(",", ".")));
					product.setInStock(line[3]);
					
					productDao.insertProduct(product);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS PRODUCT ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR PRODUCT ===========");
			e.printStackTrace();
		}
	}
}
