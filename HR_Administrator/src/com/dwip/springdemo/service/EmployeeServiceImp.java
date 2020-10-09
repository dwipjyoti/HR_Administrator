package com.dwip.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwip.springdemo.dao.EmployeeDAO;
import com.dwip.springdemo.dao.UserDAO;
import com.dwip.springdemo.entity.EmployeeTable;
import com.dwip.springdemo.entity.UserTable;




@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public Boolean checkUser(UserTable theUser) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(theUser);
	}
	

	
	@Autowired
	private EmployeeDAO employeeDAO;

	
	@Transactional
	public List<EmployeeTable> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee();
	}


	@Override
	@Transactional
	public void saveEmployee(EmployeeTable theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.saveEmployee(theEmployee);
		
	}


	@Override
	@Transactional
	public EmployeeTable getEmployees(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(theId);
	}


	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(theId);
		
	}


	


	
	
	

}
