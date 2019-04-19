package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.entity.ShippingMethod;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int index) throws SQLException {
		Order order = new Order();
		order.setOrderId(rs.getLong("order_id"));
		order.setCustomerId(rs.getLong("m_customer_id"));
		order.setEmployeeId(rs.getLong("m_employee_id"));
		order.setOrderDate(rs.getTimestamp("order_date"));
		order.setPurchaseOrderNumber(rs.getString("purchase_order_number"));
		order.setShipDate(rs.getTimestamp("ship_date"));
		order.setShippingMethodId(rs.getLong("m_shipping_method_id"));
		order.setFreightCharge(rs.getBigDecimal("freight_charge"));
		order.setTaxes(rs.getBigDecimal("taxes"));
		order.setPaymentReceived(rs.getString("payment_received"));
		order.setComment(rs.getString("comment"));
		
		try{
			ShippingMethodMapper shippingMethodMapper = new ShippingMethodMapper();
			ShippingMethod shippingMethod = shippingMethodMapper.mapRow(rs, index);
			order.setShippingMethod(shippingMethod);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try{
			CustomerMapper customerMapper = new CustomerMapper();
			Customer customer = customerMapper.mapRow(rs, index);
			order.setCustomer(customer);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		try{
			EmployeeMapper employeeMapper = new EmployeeMapper();
			Employee employee = employeeMapper.mapRow(rs, index);
			order.setEmployee(employee);
		}catch (Exception e) {
			// TODO: handle exception
		}
        return order;
	}


}
