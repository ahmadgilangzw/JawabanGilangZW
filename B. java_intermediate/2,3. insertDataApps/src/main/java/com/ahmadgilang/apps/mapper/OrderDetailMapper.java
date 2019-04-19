package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.OrderDetail;

public class OrderDetailMapper implements RowMapper<OrderDetail> {

	@Override
	public OrderDetail mapRow(ResultSet rs, int index) throws SQLException {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderDetailId(rs.getLong("order_detail_id"));
		orderDetail.setOrderId(rs.getLong("m_order_id"));
		orderDetail.setProductId(rs.getLong("m_product_id"));
		orderDetail.setQuantity(rs.getLong("quantity"));
		orderDetail.setUnitPrice(rs.getBigDecimal("unit_price"));
		orderDetail.setDiscount(rs.getBigDecimal("discount"));
        return orderDetail;
	}


}
