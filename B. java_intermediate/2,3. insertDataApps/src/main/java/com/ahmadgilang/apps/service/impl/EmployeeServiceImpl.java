package com.ahmadgilang.apps.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.EmployeeDao;
import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.service.EmployeeService;
import com.ahmadgilang.apps.utils.EngineUtils;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getCanonicalName());
	
	@Resource 
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		employeeDao.insertEmployee(emp);
		
	}
	
	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		employeeDao.deleteEmployee(emp);
		
	}

	@Override
	public void truncateEmployee() {
		employeeDao.truncateEmployee();
	}

	@Override
	public void readAndInsertEmployee(String fileName) {
		try{
			employeeDao.truncateEmployee();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					Employee e = new Employee();
					e.setEmployeeId(Long.parseLong(line[0]));
					e.setFirstName(line[1]);
					e.setLastName(line[2]);
					e.setTitle(line[3]);
					e.setWorkPhone(line[4]);
					
					employeeDao.insertEmployee(e);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS EMPLOYEE ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR EMPLOYEE ===========");
			e.printStackTrace();
		}
	}
}
