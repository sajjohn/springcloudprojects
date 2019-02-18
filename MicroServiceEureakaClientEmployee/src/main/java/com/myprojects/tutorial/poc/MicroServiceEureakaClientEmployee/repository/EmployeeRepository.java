package com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.bean.Employee;

@Repository
public interface EmployeeRepository extends  MongoRepository<Employee, String> {
	
	public List<Employee> findAll();
	
	public Employee insert(Employee emp);
	
	public Employee findByEmployeeId(Integer employeeId);
	
	
	public void deleteByEmployeeId(Integer employeeId);
	
	
}
