package com.springapp.ems_backend.service;

import java.util.List;

import com.springapp.ems_backend.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long id);
	
	List<EmployeeDto>  getAllEmployee(); 
	
	EmployeeDto updateEmployeeById(Long id, EmployeeDto updatedEmployee);
	
	void  deleteEmployee(Long id);
}
