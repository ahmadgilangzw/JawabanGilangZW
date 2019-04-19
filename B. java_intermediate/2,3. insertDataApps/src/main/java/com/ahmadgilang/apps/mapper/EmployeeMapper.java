package com.ahmadgilang.apps.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ahmadgilang.apps.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int index) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getLong("employee_id"));
		emp.setFirstName(rs.getString("first_name"));
		emp.setLastName(rs.getString("last_name"));
		emp.setTitle(rs.getString("title"));
		emp.setWorkPhone(rs.getString("work_phone"));
        return emp;
	}


}
