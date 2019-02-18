package com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.bean.Employee;
import com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;

 public void saveEmployee(Employee employee)	{
	 employeeRepository.insert(employee);
}

 public List<Employee> fetchEmployees()	{
	 return employeeRepository.findAll();
}
 
 public Employee findEmployee(String empId){
	 
	 return employeeRepository.findByEmployeeId(new Integer(empId));
 }
 
 public void deleteEmployee(String empId){
	  employeeRepository.deleteByEmployeeId(new Integer(empId));
 }
 
 
 
}
