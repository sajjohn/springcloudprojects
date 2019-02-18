package com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.model.Employee;

@FeignClient(name = "employeeservice")
public interface EmployeeServiceProxy {
	@RequestMapping(method = RequestMethod.GET, value = "/employeeservice/employees/getEmployee",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> fetchEmployees();

	@RequestMapping(method = RequestMethod.POST, value = "/employeeservice/employees/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> addEmployee(Employee employee);
	
	@RequestMapping(method = RequestMethod.GET, value = "/employeeservice/employees/getEmployee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee findEmployee(@PathVariable("empId") String employeeId);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/employeeservice/employees/deleteEmployee/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> deleteEmployee(@PathVariable("empId") String employeeId);
	

}
