package com.ahmadgilang.apps.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.OrderDao;
import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.service.OrderService;
import com.ahmadgilang.apps.utils.EngineUtils;

@Component
public class OrderServiceImpl implements OrderService{
	
	private static Logger logger = Logger.getLogger(OrderServiceImpl.class.getCanonicalName());
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Resource 
	OrderDao orderDao;
	
	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}
	
	@Override
	public void insertOrder(Order emp) {
		orderDao.insertOrder(emp);
		
	}
	
	@Override
	public void updateOrder(Order emp) {
		orderDao.updateOrder(emp);
	}

	@Override
	public void deleteOrder(Order emp) {
		orderDao.deleteOrder(emp);
		
	}

	@Override
	public void truncateOrder() {
		orderDao.truncateOrder();
	}

	@Override
	public void readAndInsertOrder(String fileName) {
		
		try{
			orderDao.truncateOrder();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					Order order = new Order();
					order.setOrderId(Long.parseLong(line[0]));
					order.setCustomerId(Long.parseLong(line[1]));
					order.setEmployeeId(Long.parseLong(line[2]));
					if(!"".equals(line[3])){
						order.setOrderDate(sdf.parse(line[3]));
					}
					order.setPurchaseOrderNumber(line[4]);
					if(!"".equals(line[5])){
						order.setShipDate(sdf.parse(line[5]));
					}
					order.setShippingMethodId(Long.parseLong(line[6]));
					if("".equals(line[7])){
						order.setFreightCharge(BigDecimal.ZERO);
					}else{
						order.setFreightCharge(new BigDecimal(line[7]));
					}
					
					if("".equals(line[8])){
						order.setTaxes(BigDecimal.ZERO);
					}else{
						order.setTaxes(new BigDecimal(line[8]));
					}

					order.setPaymentReceived(line[9]);
					
					try{
						order.setComment(line[10]);
					}catch (Exception e) {
					}
					
					orderDao.insertOrder(order);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS ORDER ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR ORDER ===========");
			e.printStackTrace();
		}
	}
}
