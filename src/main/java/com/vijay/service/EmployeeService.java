package com.vijay.service;

import java.util.List;

import com.vijay.model.Employee;

public interface EmployeeService {

	
	public Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getOneEmployee(Integer id);
	public void deleteEmployee(Integer id);
	public void  updateEmployee(Employee employee);
}
