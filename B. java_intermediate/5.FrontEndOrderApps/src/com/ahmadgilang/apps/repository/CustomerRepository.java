/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.repository;

import com.ahmadgilang.apps.entity.Customer;
import com.ahmadgilang.apps.utils.EngineUtils;
import com.ahmadgilang.apps.utils.PojoJsonMapper;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Gilang
 */
public class CustomerRepository {
    
    private static String REQUEST_ALL_CUSTOMER = "http://127.0.0.1:8080/customer/getAllCustomer";
    private static String REQUEST_ALL_GETBYID = "http://127.0.0.1:8080/customer/getById/";
    
    public static List<Customer> getAllCustomer() throws Exception{
        List<Customer> listCustomer = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_CUSTOMER);
        listCustomer = PojoJsonMapper.fromJson(result, new TypeReference<List<Customer>>(){} );
        
        return listCustomer;
    }
    
    public static Customer getById(Long id) throws Exception{
        Customer customer = new Customer();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_GETBYID+id);
        customer = PojoJsonMapper.fromJson(result, Customer.class);
        
        return customer;
    }
    
}
