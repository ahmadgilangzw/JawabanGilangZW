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

import com.ahmadgilang.apps.dao.OrderDao;
import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.mapper.OrderMapper;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	public OrderDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Order> findAll() {
		return template.query("select * from t_orders", new OrderMapper());
	}
	@Override
	public void insertOrder(Order order) {
		 final String sql = "insert into t_orders "
		 		+ " (order_id, m_customer_id, m_employee_id, order_date, purchase_order_number, ship_date, m_shipping_method_id, freight_charge, taxes, payment_received, comment) "
		 		+ " values(:orderId, :customerId, :employeeId, :orderDate, :purchaseOrderNumber, :shipDate, :shippingMethodId, :freightCharge, :taxes, :paymentReceived, :comment)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("orderId", order.getOrderId())
					.addValue("customerId", order.getCustomerId())
					.addValue("employeeId", order.getEmployeeId())
					.addValue("orderDate", order.getOrderDate())
					.addValue("purchaseOrderNumber", order.getPurchaseOrderNumber())
					.addValue("shipDate", order.getShipDate())
					.addValue("shippingMethodId", order.getShippingMethodId())
					.addValue("freightCharge", order.getFreightCharge())
					.addValue("taxes", order.getTaxes())
					.addValue("paymentReceived", order.getPaymentReceived())
					.addValue("comment", order.getComment());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateOrder(Order Order) {
		 final String sql = "update t_orders set "
		 		+ " order_id = :orderId, m_customer_id = :customerId, m_employee_id = :employeeId, order_date = :orderDate, purchase_order_number = :purchaseOrderNumber,"
		 		+ " ship_date = :shipDate, m_shipping_method_id = :shippingMethodId, freight_charge = :freightCharge, taxes = :taxes, payment_received = :paymentReceived, comment = :comment"
		 		+ " where order_id = :orderId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("orderId", Order.getOrderId())
					.addValue("customerId", Order.getCustomerId())
					.addValue("employeeId", Order.getEmployeeId())
					.addValue("orderDate", Order.getOrderDate())
					.addValue("purchaseOrderNumber", Order.getPurchaseOrderNumber())
					.addValue("shipDate", Order.getShipDate())
					.addValue("shippingMethodId", Order.getShippingMethodId())
					.addValue("freightCharge", Order.getFreightCharge())
					.addValue("taxes", Order.getTaxes())
					.addValue("paymentReceived", Order.getPaymentReceived())
					.addValue("comment", Order.getComment());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void deleteOrder(Order emp) {
		 final String sql = "delete from t_orders where order_id = :orderId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("orderId", emp.getOrderId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void truncateOrder() {
		final String sql = "truncate t_orders";
		
		template.execute(sql,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
}
