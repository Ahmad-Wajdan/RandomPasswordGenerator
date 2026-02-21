package com.springapp.ems_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springapp.ems_backend.dto.EmployeeDto;
import com.springapp.ems_backend.entity.Employee;
import com.springapp.ems_backend.mapper.EmployeeMapper;
import com.springapp.ems_backend.repository.EmployeeRepository;
import com.springapp.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository ;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmploye = employeeRepository.save(employee); 
		return EmployeeMapper.mapToEmployeeDto(savedEmploye);
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {

		 Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Doesn't Exist"));
		 
		return EmployeeMapper.mapToEmployeeDto(employee);
	}


	@Override
	public List<EmployeeDto> getAllEmployee() {

		
		return employeeRepository.findAll().stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployeeById(Long id, EmployeeDto updatedEmployee) {

		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Doesn't Exist"));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long id) {

		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Doesn't Exist"));
		
		employeeRepository.delete(employee);

	}

}
