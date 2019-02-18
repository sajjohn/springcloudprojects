package com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.bean.Employee;
import com.myprojects.tutorial.poc.MicroServiceEureakaClientEmployee.service.EmployeeService;



@RestController
@RequestMapping(path="/employees")

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Employee> addEmployee(@RequestBody Employee emp) {
	
		employeeService.saveEmployee(emp);
		return employeeService.fetchEmployees();

	}
	
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Employee> getEmployee() {
	
		
		return employeeService.fetchEmployees();

	}
	
	@RequestMapping(value = "/getEmployee/{empId}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Employee findEmployee(@PathVariable("empId") String employeeId) {
	
		
		return employeeService.findEmployee(employeeId);

	}
	
	
	@RequestMapping(value = "/deleteEmployee/{empId}", method = RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Employee> deleteEmployee(@PathVariable("empId") String employeeId) {
	
		
		 employeeService.deleteEmployee(employeeId);
		 return employeeService.fetchEmployees();

	}
	
	
	
}
