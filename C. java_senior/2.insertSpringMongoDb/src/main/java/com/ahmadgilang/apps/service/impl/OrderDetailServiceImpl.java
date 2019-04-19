package com.ahmadgilang.apps.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.OrderDetailDao;
import com.ahmadgilang.apps.entity.OrderDetail;
import com.ahmadgilang.apps.service.OrderDetailService;
import com.ahmadgilang.apps.utils.EngineUtils;

@Component
public class OrderDetailServiceImpl implements OrderDetailService{
	
	private static Logger logger = Logger.getLogger(OrderDetailServiceImpl.class.getCanonicalName());
	
	@Resource 
	OrderDetailDao orderDetailDao;
	
	@Override
	public List<OrderDetail> findAll() {
		return orderDetailDao.findAll();
	}
	
	@Override
	public void readAndInsertOrderDetail(String fileName) {
		try{
			orderDetailDao.deleteAll();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.set_id(line[0]);
					orderDetail.setOrderId(line[1]);
					orderDetail.setProductId(line[2]);
					orderDetail.setQuantity(Long.parseLong(line[3]));
					
					if("".equals(line[4])){
						orderDetail.setUnitPrice(0.0);
					}else{
						orderDetail.setUnitPrice(Double.valueOf(line[4].replace(",", ".")));
					}
					
					if("".equals(line[5])){
						orderDetail.setDiscount(0.0);
					}else{
						orderDetail.setDiscount(Double.valueOf(line[5].replace("%", "")));
					}
					
					orderDetailDao.save(orderDetail);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS ORDER_DETAIL ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR ORDER_DETAIL ===========");
			e.printStackTrace();
		}
	}
}
