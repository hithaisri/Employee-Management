package com.emp.service;

import java.util.List;
import java.util.Optional;

import com.emp.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Optional<Employee> getEmployee(Integer id);

	public void deleteEmployee(Integer id);

	public void deleteAllEmployees();
}
