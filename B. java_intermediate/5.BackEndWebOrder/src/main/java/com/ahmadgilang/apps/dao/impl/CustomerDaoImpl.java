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

import com.ahmadgilang.apps.dao.CustomerDao;
import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.mapper.CustomerMapper;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	public CustomerDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Customer> findAll() {
		return template.query("select * from m_customers", new CustomerMapper());
	}
	@Override
	public void insertCustomer(Customer cust) {
		 final String sql = "insert into m_customers "
		 		+ " (customer_id, company_name, first_name, last_name, billing_address, city, state_or_province, zip_code, email, "
		 		+ " company_website, phone_number, fax_number, ship_address, ship_city, ship_state_or_province, ship_zip_code, ship_phone_number) "
		 		+ " values(:customerId, :companyName, :firstName, :lastName, :billingAddress, :city, :stateOrProvince, :zipCode, :email,"
		 		+ " :companyWebsite, :phoneNumber, :faxNumber, :shipAddress, :shipCity, :shipStateOrProvince, :shipZipCode, :shipPhoneNumber)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("customerId", cust.getCustomerId())
					.addValue("companyName", cust.getCompanyName())
					.addValue("firstName", cust.getFirstName())
					.addValue("lastName", cust.getLastName())
			        .addValue("billingAddress", cust.getBillingAddress())
			        .addValue("city", cust.getCity())
			        .addValue("stateOrProvince", cust.getStateOrProvince())
			        .addValue("zipCode", cust.getZipCode())
			        .addValue("email", cust.getEmail())
			        .addValue("companyWebsite", cust.getCompanyWebsite())
			        .addValue("phoneNumber", cust.getPhoneNumber())
			        .addValue("faxNumber", cust.getFaxNumber())
			        .addValue("shipAddress", cust.getShipAddress())
			        .addValue("shipCity", cust.getShipCity())
			        .addValue("shipStateOrProvince", cust.getShipStateOrProvince())
			        .addValue("shipZipCode", cust.getShipZipCode())
			        .addValue("shipPhoneNumber", cust.getShipPhoneNumber());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateCustomer(Customer cust) {
		 final String sql = "update m_customers set "
		 		+ " company_name = :companyName, first_name = :firstName, last_name = :lastName, billing_address = :billingAddress, city = :city, state_or_province = :stateOrProvince, "
		 		+ " zip_code = :zipCode, email = :email, company_website = :companyWebsite, phone_number = :phoneNumber, fax_number = :faxNumber, ship_address = :shipAddress, "
		 		+ " ship_city = :shipCity, ship_state_or_province = :shipStateOrProvince, ship_zip_code = :shipZipCode, ship_phone_number = :shipPhoneNumber "
		 		+ " where customer_id = :customerId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("customerId", cust.getCustomerId())
					.addValue("companyName", cust.getCompanyName())
					.addValue("firstName", cust.getFirstName())
					.addValue("lastName", cust.getLastName())
			        .addValue("billingAddress", cust.getBillingAddress())
			        .addValue("city", cust.getCity())
			        .addValue("stateOrProvince", cust.getStateOrProvince())
			        .addValue("zipCode", cust.getZipCode())
			        .addValue("email", cust.getEmail())
			        .addValue("companyWebsite", cust.getCompanyWebsite())
			        .addValue("phoneNumber", cust.getPhoneNumber())
			        .addValue("faxNumber", cust.getFaxNumber())
			        .addValue("shipAddress", cust.getShipAddress())
			        .addValue("shipCity", cust.getShipCity())
			        .addValue("shipStateOrProvince", cust.getShipStateOrProvince())
			        .addValue("shipZipCode", cust.getShipZipCode())
			        .addValue("shipPhoneNumber", cust.getShipPhoneNumber());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void deleteCustomer(Customer cust) {
		 final String sql = "delete from m_customers where customer_id = :customerId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("customerId", cust.getCustomerId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void truncateCustomer() {
		final String sql = "truncate m_customers";
		
		template.execute(sql,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
}
