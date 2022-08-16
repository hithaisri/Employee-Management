package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;

	@RequestMapping("/hello")
	public String hello(){
		return "Hellow World";
	}
	
	@PostMapping("/employee")
	public Integer saveEmployee(@RequestBody Employee employee) {
		Integer id=employeeService.saveEmployee(employee);
		System.out.println("Id"+id);
		return id;
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployee() {
		//Add new comment line 
		return employeeService.getAllEmployees();
	}
}
