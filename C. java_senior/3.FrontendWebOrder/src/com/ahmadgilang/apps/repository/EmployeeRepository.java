/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.repository;

import com.ahmadgilang.apps.entity.Employee;
import com.ahmadgilang.apps.utils.EngineUtils;
import com.ahmadgilang.apps.utils.PojoJsonMapper;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Gilang
 */
public class EmployeeRepository {
    
    private static String REQUEST_ALL_EMPLOYEE = "http://127.0.0.1:8080/employee/getAllEmployee";
    private static String REQUEST_ALL_GETBYID = "http://127.0.0.1:8080/employee/getById?id=";
    
    public static List<Employee> getAllEmployee() throws Exception{
        List<Employee> listEmployee = new ArrayList<>();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_EMPLOYEE);
        listEmployee = PojoJsonMapper.fromJson(result, new TypeReference<List<Employee>>(){} );
        
        return listEmployee;
    }
    
     public static Employee getById(String id) throws Exception{
        Employee employee = new Employee();
        
        String result = EngineUtils.getRequestData(REQUEST_ALL_GETBYID+id);
        employee = PojoJsonMapper.fromJson(result, Employee.class);
        
        return employee;
    }
    
}
