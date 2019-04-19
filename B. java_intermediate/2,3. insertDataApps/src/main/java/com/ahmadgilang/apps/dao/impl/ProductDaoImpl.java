package com.ahmadgilang.apps.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ahmadgilang.apps.dao.ProductDao;
import com.ahmadgilang.apps.entity.Product;
import com.ahmadgilang.apps.mapper.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	public ProductDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Product> findAll() {
		return template.query("select * from m_products", new ProductMapper());
	}
	@Override
	public void insertProduct(Product product) {
		 final String sql = "insert into m_products "
		 		+ " (product_id, product_name, unit_price, in_stock) "
		 		+ " values(:productId, :productName, :unitPrice, :inStock)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("productId", product.getProductId())
					.addValue("productName", product.getProductName())
					.addValue("unitPrice", product.getUnitPrice())
					.addValue("inStock", product.getInStock());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateProduct(Product product) {
		 final String sql = "update m_products set "
		 		+ " product_name = :productName, unit_price = :unitPrice, in_stock = :inStock "
		 		+ " where product_id = :productId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("productId", product.getProductId())
					.addValue("productName", product.getProductName())
					.addValue("unitPrice", product.getUnitPrice())
					.addValue("inStock", product.getInStock());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void deleteProduct(Product emp) {
		 final String sql = "delete from m_products where product_id = :productId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("ProductId", emp.getProductId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void truncateProduct() {
		final String sql = "truncate m_products";
		
		template.execute(sql,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
}
