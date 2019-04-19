package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int index) throws SQLException {
		Order Order = new Order();
		Order.setOrderId(rs.getLong("order_id"));
		Order.setCustomerId(rs.getLong("m_customer_id"));
		Order.setEmployeeId(rs.getLong("m_employee_id"));
		Order.setOrderDate(rs.getTimestamp("order_date"));
		Order.setPurchaseOrderNumber(rs.getString("purchase_order_number"));
		Order.setShipDate(rs.getTimestamp("ship_date"));
		Order.setShippingMethodId(rs.getLong("m_shipping_method_id"));
		Order.setFreightCharge(rs.getBigDecimal("freight_charge"));
		Order.setTaxes(rs.getBigDecimal("texes"));
		Order.setPaymentReceived(rs.getString("payment_received"));
		Order.setComment(rs.getString("comment"));
        return Order;
	}


}
