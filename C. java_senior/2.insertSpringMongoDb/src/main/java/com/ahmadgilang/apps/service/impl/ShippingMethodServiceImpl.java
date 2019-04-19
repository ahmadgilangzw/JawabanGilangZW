package com.ahmadgilang.apps.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ahmadgilang.apps.dao.ShippingMethodDao;
import com.ahmadgilang.apps.entity.ShippingMethod;
import com.ahmadgilang.apps.service.ShippingMethodService;
import com.ahmadgilang.apps.utils.EngineUtils;

@Component
public class ShippingMethodServiceImpl implements ShippingMethodService{
	
	private static Logger logger = Logger.getLogger(ShippingMethodServiceImpl.class.getCanonicalName());
	
	@Resource 
	ShippingMethodDao shippingMethodDao;
	
	@Override
	public List<ShippingMethod> findAll() {
		return shippingMethodDao.findAll();
	}
	
	@Override
	public void readAndInsertShippingMethod(String fileName) {
		try{
			shippingMethodDao.deleteAll();
			
			List<String> list = new ArrayList<>();
			list = EngineUtils.getDataList(fileName);
			
			for (int i = 0; i < list.size(); i++) {
				if(i != 0){
					String[] line = list.get(i).split(";");
					ShippingMethod shippingMethod = new ShippingMethod();
					shippingMethod.set_id(line[0]);
					shippingMethod.setShippingMethod(line[1]);
					
					shippingMethodDao.save(shippingMethod);
				}
			}
			logger.log(Level.INFO, "========== SUCCESS SHIPPING_METHOD ===========");
		}catch (Exception e) {
			logger.log(Level.INFO, "========== ERROR SHIPPING_METHOD ===========");
			e.printStackTrace();
		}
	}
}
