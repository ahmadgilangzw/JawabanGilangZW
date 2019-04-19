package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int index) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getLong("product_id"));
		product.setProductName(rs.getString("product_name"));
		product.setUnitPrice(rs.getBigDecimal("unit_price"));
		product.setInStock(rs.getString("in_stock"));
        return product;
	}


}
