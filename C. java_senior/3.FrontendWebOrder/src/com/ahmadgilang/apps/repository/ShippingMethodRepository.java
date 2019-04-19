/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.repository;

import com.ahmadgilang.apps.entity.ShippingMethod;
import com.ahmadgilang.apps.utils.EngineUtils;
import com.ahmadgilang.apps.utils.PojoJsonMapper;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Gilang
 */
public class ShippingMethodRepository {
    
    private static String REQUEST_ALL_SHIPPINGMETHOD = "http://127.0.0.1:8080/shippingMethod/getAllShippingMethod";
    private static String REQUEST_ALL_GETBYID = "http://127.0.0.1:8080/shippingMethod/getById?id=";
    
    public static List<ShippingMethod> getAllShippingMethod() throws Exception{
        List<ShippingMethod> listShippingMethod = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_SHIPPINGMETHOD);
        listShippingMethod = PojoJsonMapper.fromJson(result, new TypeReference<List<ShippingMethod>>(){} );
        
        return listShippingMethod;
    }
    
    public static ShippingMethod getById(String id) throws Exception{
        ShippingMethod shippingMethod = new ShippingMethod();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_GETBYID+id);
        shippingMethod = PojoJsonMapper.fromJson(result, ShippingMethod.class);
        
        return shippingMethod;
    }
    
}
