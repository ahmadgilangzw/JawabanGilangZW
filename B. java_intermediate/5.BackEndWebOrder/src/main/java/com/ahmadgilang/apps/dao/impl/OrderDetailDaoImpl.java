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

import com.ahmadgilang.apps.dao.OrderDetailDao;
import com.ahmadgilang.apps.entity.OrderDetail;
import com.ahmadgilang.apps.mapper.OrderDetailMapper;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao{
	
	public OrderDetailDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<OrderDetail> findAll() {
		return template.query("select od.*, p.* from t_order_details od "
				+ " join t_orders o ON(od.m_order_id = o.order_id) "
				+ " join m_products p ON(od.m_product_id = p.product_id) order by o.order_date asc", new OrderDetailMapper());
	}
	
	@Override
	public List<OrderDetail> findAllByParam(Long orderId) {
		return template.query("select od.*, p.* from t_order_details od "
				+ " join t_orders o ON(od.m_order_id = o.order_id) "
				+ " join m_products p ON(od.m_product_id = p.product_id) "
				+ " where o.order_id = "+orderId +" order by o.order_date asc" , new OrderDetailMapper());
	}
	
	@Override
	public void insertOrderDetail(OrderDetail orderDetail) {
		 final String sql = "insert into t_order_details "
		 		+ " (order_detail_id, m_order_id, m_product_id, quantity, unit_price, discount) "
		 		+ " values(:orderDetailId, :orderId, :productId, :quantity, :unitPrice, :discount)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("orderDetailId", orderDetail.getOrderDetailId())
					.addValue("orderId", orderDetail.getOrderId())
					.addValue("productId", orderDetail.getProductId())
					.addValue("quantity", orderDetail.getQuantity())
			        .addValue("unitPrice", orderDetail.getUnitPrice())
	        		.addValue("discount", orderDetail.getDiscount());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		 final String sql = "update t_order_details set "
		 		+ " m_order_id = :orderId, m_product_id = :productId, quantity = :quantity, unit_price = :unitPrice, discount = :discount"
		 		+ " where order_detail_id = :orderDetailId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
	        		.addValue("orderDetailId", orderDetail.getOrderDetailId())
					.addValue("orderId", orderDetail.getOrderId())
					.addValue("productId", orderDetail.getProductId())
					.addValue("quantity", orderDetail.getQuantity())
			        .addValue("unitPrice", orderDetail.getUnitPrice())
	        		.addValue("discount", orderDetail.getDiscount());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void deleteOrderDetail(OrderDetail emp) {
		 final String sql = "delete from t_order_details where order_detail_id = :orderDetailId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("orderDetailId", emp.getOrderDetailId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
	@Override
	public void truncateOrderDetail() {
		final String sql = "truncate t_order_details";
		
		template.execute(sql,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
}
