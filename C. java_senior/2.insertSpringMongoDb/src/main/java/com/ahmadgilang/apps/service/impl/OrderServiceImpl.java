package com.ahmadgilang.apps.service.impl;

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
	public void readAndInsertOrder(String fileName) {
		
		try{
			orderDao.deleteAll();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					Order order = new Order();
					order.set_id(line[0]);
					order.setCustomerId(line[1]);
					order.setEmployeeId(line[2]);
					if(!"".equals(line[3])){
						order.setOrderDate(sdf.parse(line[3]));
					}
					order.setPurchaseOrderNumber(line[4]);
					if(!"".equals(line[5])){
						order.setShipDate(sdf.parse(line[5]));
					}
					order.setShippingMethodId(line[6]);
					if("".equals(line[7])){
						order.setFreightCharge(0.0);
					}else{
						order.setFreightCharge(Double.valueOf(line[7]));
					}
					
					if("".equals(line[8])){
						order.setTaxes(0.0);
					}else{
						order.setTaxes(Double.valueOf(line[8]));
					}

					order.setPaymentReceived(line[9]);
					
					try{
						order.setComment(line[10]);
					}catch (Exception e) {
					}
					
					orderDao.save(order);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS ORDER ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR ORDER ===========");
			e.printStackTrace();
		}
	}
}
