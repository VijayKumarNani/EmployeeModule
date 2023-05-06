package com.vijay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vijay.exception.EmployeeNotFoundException;
import com.vijay.model.Employee;
import com.vijay.repo.EmployeeRepository;
import com.vijay.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmployee(Employee employee) {
		return repo.save(employee).getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	@Cacheable(value="employees",key="#id")
	public Employee getOneEmployee(Integer id) {
				
   //Optional<Employee> opt= repo.findById(id); Employee employee=opt.get();return employee;
		
   Employee employee= repo.findById(id).orElseThrow(()->
                        new EmployeeNotFoundException("Employee '"+id+"' Not Exists"));
	return employee;   
	
	}

	@Override
	//@CacheEvict(value="employees",allEntries=true)  =>It will delete all entries in cache
	
	@CacheEvict(value="employees",key="#id")
	public void deleteEmployee(Integer id) {
		
        //repo.deleteById(id);
		 Employee employee= repo.findById(id).orElseThrow(()->
                                            new EmployeeNotFoundException("Employee '"+id+"' Not Exists"));
		 repo.delete(employee);

	}

	@Override
	@CachePut(value="employees",key="#employee.id")
	public void updateEmployee(Employee employee) {
 if(employee.getId()!=null)
 {
	 repo.save(employee);
 }
	}

}
