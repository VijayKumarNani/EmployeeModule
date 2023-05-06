package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
