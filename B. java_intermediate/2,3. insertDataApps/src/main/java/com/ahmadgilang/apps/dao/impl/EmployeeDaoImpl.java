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

import com.ahmadgilang.apps.dao.EmployeeDao;
import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.mapper.EmployeeMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Employee> findAll() {
		return template.query("select * from m_employees", new EmployeeMapper());
	}
	@Override
	public void insertEmployee(Employee emp) {
		 final String sql = "insert into m_employees "
		 		+ " (employee_id, first_name, last_name, title, work_phone) "
		 		+ " values(:employeeId, :firstName, :lastName, :title, :workPhone)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("employeeId", emp.getEmployeeId())
					.addValue("firstName", emp.getFirstName())
					.addValue("lastName", emp.getLastName())
					.addValue("title", emp.getTitle())
			        .addValue("workPhone", emp.getWorkPhone());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		 final String sql = "update m_employees set "
		 		+ " first_name = :firstName, last_name = :lastName, title = :title, work_phone = :workPhone "
		 		+ " where employee_id = :employeeId";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("employeeId", emp.getEmployeeId())
					.addValue("firstName", emp.getFirstName())
					.addValue("lastName", emp.getLastName())
					.addValue("title", emp.getTitle())
			        .addValue("workPhone", emp.getWorkPhone());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void deleteEmployee(Employee emp) {
		 final String sql = "delete from m_employees where employee_id = :employeeId";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("employeeId", emp.getEmployeeId());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void truncateEmployee() {
		final String sql = "truncate m_employees";
		
		template.execute(sql,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
}
