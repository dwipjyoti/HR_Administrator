package com.dwip.springdemo.dao;

import java.util.*;
import com.dwip.springdemo.entity.EmployeeTable;

public interface EmployeeDAO {
	public List<EmployeeTable> getEmployee();

	public void saveEmployee(EmployeeTable theEmployee);

	public EmployeeTable getEmployee(int theId);

	public void deleteEmployee(int theId);
}
