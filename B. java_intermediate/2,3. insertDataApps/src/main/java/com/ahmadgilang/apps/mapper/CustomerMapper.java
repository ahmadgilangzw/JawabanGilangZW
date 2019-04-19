package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int index) throws SQLException {
		Customer cust = new Customer();
		cust.setCustomerId(rs.getLong("customer_id"));
		cust.setCompanyName(rs.getString("company_name"));
		cust.setFirstName(rs.getString("first_name"));
		cust.setLastName(rs.getString("last_name"));
		cust.setBillingAddress(rs.getString("billing_address"));
		cust.setCity(rs.getString("city"));
		cust.setStateOrProvince(rs.getString("state_or_province"));
		cust.setZipCode(rs.getString("zip_code"));
		cust.setEmail(rs.getString("email"));
		cust.setCompanyWebsite(rs.getString("company_website"));
		cust.setPhoneNumber(rs.getString("phone_number"));
		cust.setFaxNumber(rs.getString("fax_number"));
		cust.setShipAddress(rs.getString("ship_address"));
		cust.setShipCity(rs.getString("ship_city"));
		cust.setShipStateOrProvince(rs.getString("ship_state_or_province"));
		cust.setShipZipCode(rs.getString("ship_zip_code"));
		cust.setShipPhoneNumber(rs.getString("ship_phone_number"));
        return cust;
	}


}
