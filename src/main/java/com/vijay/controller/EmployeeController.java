package com.vijay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.model.Employee;
import com.vijay.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Integer id = service.saveEmployee(employee);
		String message = "Employee '" + id + "' SAVED";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = service.getAllEmployees();

		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Integer id) {
		try {
			Employee employee = service.getOneEmployee(id);

			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {

		try {
			service.deleteEmployee(id);
			String message = "Employee '" + id + "' DELETED";

			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee);
		String message = "Employee '" + employee.getId() + "' UPDATED";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
