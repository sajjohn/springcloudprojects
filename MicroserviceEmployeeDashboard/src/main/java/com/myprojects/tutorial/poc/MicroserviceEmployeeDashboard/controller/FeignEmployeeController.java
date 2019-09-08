package com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.client.EmployeeServiceProxy;
import com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.model.Employee;

@RestController
@RequestMapping(path="/feign")
public class FeignEmployeeController {
@Autowired
private EmployeeServiceProxy employeeServiceProxy;

@PreAuthorize("#oauth2.hasScope('write')")
@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
public @ResponseBody List<Employee> addEmployee(@RequestBody Employee emp) {

	return employeeServiceProxy.addEmployee(emp);

}

@PreAuthorize("#oauth2.hasScope('read')")
@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
public @ResponseBody List<Employee> getEmployee() {

	
	return employeeServiceProxy.fetchEmployees();

}
@PreAuthorize("#oauth2.hasScope('read')")
@RequestMapping(value = "/getEmployee/{empId}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
public @ResponseBody Employee findEmployee(@PathVariable("empId") String employeeId) {

	
	return employeeServiceProxy.findEmployee(employeeId);

}

@PreAuthorize("#oauth2.hasScope('write')")
@RequestMapping(value = "/deleteEmployee/{empId}", method = RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE})
public @ResponseBody List<Employee> deleteEmployee(@PathVariable("empId") String employeeId) {

	
	return employeeServiceProxy.deleteEmployee(employeeId);

}


}
