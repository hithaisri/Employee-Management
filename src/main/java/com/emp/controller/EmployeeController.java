package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getEmployee")
	public Optional<Employee> getEmployee(@RequestParam Integer id) {
		return employeeService.getEmployee(id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
		ResponseEntity<Employee> responseEntity=new ResponseEntity<>(HttpStatus.OK);
		try {
		employeeService.deleteEmployee(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			responseEntity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	
	@DeleteMapping("/deleteAllEmployees")
	public void deleteAllEmployees() {
		employeeService.deleteAllEmployees();
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Integer id) {
		return new	ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
}
