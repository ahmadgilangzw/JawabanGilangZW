/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahmadgilang.apps.entity;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public class Employee implements Serializable{
/**
* 
*/
private static final long serialVersionUID = -3867999624792913599L;
private Long employeeId;
private String firstName;
private String lastName;
private String title;
private String workPhone;

public Employee() {
       super();
       // TODO Auto-generated constructor stub
}

public Long getEmployeeId() {
       return employeeId;
}

public void setEmployeeId(Long employeeId) {
       this.employeeId = employeeId;
}

public String getFirstName() {
       return firstName;
}

public void setFirstName(String firstName) {
       this.firstName = firstName;
}

public String getLastName() {
       return lastName;
}

public void setLastName(String lastName) {
       this.lastName = lastName;
}

public String getTitle() {
       return title;
}

public void setTitle(String title) {
       this.title = title;
}

public String getWorkPhone() {
       return workPhone;
}

public void setWorkPhone(String workPhone) {
       this.workPhone = workPhone;
}
}
