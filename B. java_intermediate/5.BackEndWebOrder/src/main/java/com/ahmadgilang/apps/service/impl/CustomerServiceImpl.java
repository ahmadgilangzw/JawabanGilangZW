package com.ahmadgilang.apps.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.CustomerDao;
import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.service.CustomerService;
import com.ahmadgilang.apps.utils.EngineUtils;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class.getCanonicalName());
	
	@Resource 
	CustomerDao customerDao;
	
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
	@Override
	public void insertCustomer(Customer customer) {
		customerDao.insertCustomer(customer);
		
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		
	}

	@Override
	public void truncateCustomer() {
		customerDao.truncateCustomer();
	}

	@Override
	public void readAndInsertCustomer(String fileName) {
		try{
			customerDao.truncateCustomer();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					Customer customer = new Customer();
					customer.setCustomerId(Long.parseLong(line[0]));
					customer.setCompanyName(line[1]);
					customer.setFirstName(line[2]);
					customer.setLastName(line[3]);
					customer.setBillingAddress(line[4]);
					customer.setCity(line[5]);
					customer.setStateOrProvince(line[6]);
					customer.setZipCode(line[7]);
					customer.setEmail(line[8]);
					customer.setCompanyWebsite(line[9]);
					customer.setPhoneNumber(line[10]);
					customer.setFaxNumber(line[11]);
					customer.setShipAddress(line[12]);
					customer.setShipCity(line[13]);
					customer.setShipStateOrProvince(line[14]);
					customer.setShipZipCode(line[15]);
					customer.setShipPhoneNumber(line[16]);
					
					customerDao.insertCustomer(customer);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS CUSTOMER ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR CUSTOMER ===========");
			e.printStackTrace();
		}
	}
}
