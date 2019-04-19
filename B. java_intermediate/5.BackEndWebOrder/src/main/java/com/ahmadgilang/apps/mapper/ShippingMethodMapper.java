package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.ShippingMethod;

public class ShippingMethodMapper implements RowMapper<ShippingMethod> {

	@Override
	public ShippingMethod mapRow(ResultSet rs, int index) throws SQLException {
		ShippingMethod shippingMethod = new ShippingMethod();
		shippingMethod.setShippingMethodId(rs.getLong("shipping_method_id"));
		shippingMethod.setShippingMethod(rs.getString("shipping_method"));
        return shippingMethod;
	}


}
