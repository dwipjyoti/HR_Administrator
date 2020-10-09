package com.dwip.springdemo.service;

import java.util.List;

import com.dwip.springdemo.entity.EmployeeTable;
import com.dwip.springdemo.entity.UserTable;

public interface EmployeeService {
	
	
	
	
	public List<EmployeeTable> getEmployees();

	public void saveEmployee(EmployeeTable theEmployee);

	public EmployeeTable getEmployees(int theId);

	public void deleteEmployee(int theId);

	public Boolean checkUser(UserTable theUser);

}
