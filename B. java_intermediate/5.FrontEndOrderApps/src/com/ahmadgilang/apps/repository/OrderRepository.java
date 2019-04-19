/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.repository;

import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.utils.EngineUtils;
import com.ahmadgilang.apps.utils.PojoJsonMapper;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Gilang
 */
public class OrderRepository {
    
    private static String REQUEST_ALL_ORDER = "http://127.0.0.1:8080/order/getAllOrder";
    
    public static List<Order> getAllOrder() throws Exception{
        List<Order> listOrder = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_ORDER);
        System.out.println(result);
        listOrder = PojoJsonMapper.fromJson(result, new TypeReference<List<Order>>(){} );
        
        return listOrder;
    }
    
}
