package com.myprojects.tutorial.poc.MicroserviceEmployeeDashboard.model;

import java.math.BigDecimal;

public class Employee {
	
	private Integer employeeId;
	private String employeeName;
	private String employeeDesignation;
	private BigDecimal employeeExperience;
	private String employeeAddress;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public BigDecimal getEmployeeExperience() {
		return employeeExperience;
	}
	public void setEmployeeExperience(BigDecimal d) {
		this.employeeExperience = d;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDesignation="
				+ employeeDesignation + ", employeeExperience=" + employeeExperience + ", employeeAddress="
				+ employeeAddress + "]";
	}

}
