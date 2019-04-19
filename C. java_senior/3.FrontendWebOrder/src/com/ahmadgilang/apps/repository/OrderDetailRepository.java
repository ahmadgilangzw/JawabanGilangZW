/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.repository;

import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.entity.OrderDetail;
import com.ahmadgilang.apps.utils.EngineUtils;
import com.ahmadgilang.apps.utils.PojoJsonMapper;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Gilang
 */
public class OrderDetailRepository {
    
    private static String REQUEST_ALL_ORDER_DETAIL = "http://127.0.0.1:8080/order-detail/getAllOrderDetail";
    private static String REQUEST_ALL_ORDER_DETAIL_BY_ORDER_ID = "http://127.0.0.1:8080/order-detail/getByOrderId?orderId=";
    
    public static List<OrderDetail> getAllOrder() throws Exception{
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_ORDER_DETAIL);
        System.out.println(result);
        listOrderDetail = PojoJsonMapper.fromJson(result, new TypeReference<List<OrderDetail>>(){} );
        
        for (OrderDetail orderDetail : listOrderDetail) {
            orderDetail.setProduct(ProductRepository.getById(orderDetail.getProductId()));
        }
        
        return listOrderDetail;
    }
    
     public static List<OrderDetail> getAllOrderByOrderId(String orderId) throws Exception{
        List<OrderDetail> listOrderDetail = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_ORDER_DETAIL_BY_ORDER_ID+orderId);
        System.out.println(result);
        listOrderDetail = PojoJsonMapper.fromJson(result, new TypeReference<List<OrderDetail>>(){} );
        
        for (OrderDetail orderDetail : listOrderDetail) {
            orderDetail.setProduct(ProductRepository.getById(orderDetail.getProductId()));
        }
        
        return listOrderDetail;
    }
    
}
