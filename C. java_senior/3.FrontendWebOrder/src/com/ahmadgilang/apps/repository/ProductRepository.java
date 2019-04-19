/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.repository;

import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.entity.Order;
import com.ahmadgilang.apps.entity.Product;
import com.ahmadgilang.apps.utils.EngineUtils;
import com.ahmadgilang.apps.utils.PojoJsonMapper;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Gilang
 */
public class ProductRepository {
    
    private static String REQUEST_ALL_PRODUCT = "http://127.0.0.1:8080/product/getAllProduct";
    private static String REQUEST_ALL_GETBYID = "http://127.0.0.1:8080/product/getById?id=";
    
    public static List<Product> getAllProduct() throws Exception{
        List<Product> listProduct = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_PRODUCT);
        System.out.println(result);
        listProduct = PojoJsonMapper.fromJson(result, new TypeReference<List<Product>>(){} );
       
        return listProduct;
    }
    
    public static Product getById(String id) throws Exception{
        Product product = new Product();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_GETBYID+id);
        System.out.println(result);
        product = PojoJsonMapper.fromJson(result, Product.class);
       
        return product;
    }
    
}
