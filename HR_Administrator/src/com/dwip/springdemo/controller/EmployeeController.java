package com.dwip.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dwip.springdemo.entity.EmployeeTable;
import com.dwip.springdemo.entity.UserTable;
import com.dwip.springdemo.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	
	
	@GetMapping("/login")
	public String login(Model theModel) {
		
		UserTable theUser=new UserTable();
		
		theModel.addAttribute("user", theUser);
		
		return "loginForm";
	}
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/processLogin")
	public String processLogin(@ModelAttribute("user") UserTable theUser,Model theModel) {
		
		//get customers from Service
		List<EmployeeTable> theEmployee=employeeService.getEmployees();
		
		//add customer to the model
		theModel.addAttribute("employees", theEmployee);
		
		Boolean checkTheUser=employeeService.checkUser(theUser);
		
		if(checkTheUser) {
			return "list-employee";
			
		}
		else {
			theModel.addAttribute("msg", "invalid Username or Password");
			return "loginForm";
		}
	}
	
	
	
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		//get customers from Service
		List<EmployeeTable> theEmployee=employeeService.getEmployees();
		
		//add customer to the model
		theModel.addAttribute("employees", theEmployee);
		
		
		
	
		return "list-employee";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		
		EmployeeTable theEmployee=new EmployeeTable();
		
		theModel.addAttribute("employee", theEmployee);
		
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeTable theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		//get data from service
		EmployeeTable theEmployee=employeeService.getEmployees(theId);
		
		//set customer as model attribute to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over the form
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId, Model theModel) {
		
		//delete customer from service
		employeeService.deleteEmployee(theId);
		return "redirect:/employee/list";
	}
}
