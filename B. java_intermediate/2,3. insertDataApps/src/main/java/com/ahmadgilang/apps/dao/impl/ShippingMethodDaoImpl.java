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

import com.ahmadgilang.apps.dao.ShippingMethodDao;
import com.ahmadgilang.apps.entity.ShippingMethod;
import com.ahmadgilang.apps.mapper.ShippingMethodMapper;

@Repository
public class ShippingMethodDaoImpl implements ShippingMethodDao{
	
	public ShippingMethodDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<ShippingMethod> findAll() {
		return template.query("select * from m_shipping_methods", new ShippingMethodMapper());
	}
	@Override
	public void insertShippingMethod(ShippingMethod shippingMethod) {
		 final String sql = "insert into m_shipping_methods "
		 		+ " (shipping_method_id, shipping_method) "
		 		+ " values(:shippingMethodId, :shippingMethod)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("shippingMethodId", shippingMethod.getShippingMethodId())
					.addValue("shippingMethod", shippingMethod.getShippingMethod());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateShippingMethod(ShippingMethod shippingMethod) {
		 final String sql = "update m_shipping_methods set "
		 		+ " shipping_method = :shippingMethod"
		 		+ " where shipping_method_id = :shippingMethodId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("shippingMethodId", shippingMethod.getShippingMethodId())
					.addValue("shippingMethod", shippingMethod.getShippingMethod());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void deleteShippingMethod(ShippingMethod emp) {
		 final String sql = "delete from m_shipping_methods where shipping_method_id = :shippingMethodId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("shippingMethodId", emp.getShippingMethodId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void truncateShippingMethod() {
		final String sql = "truncate m_shipping_methods";
		
		template.execute(sql,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
}
