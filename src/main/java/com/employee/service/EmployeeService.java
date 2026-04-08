package com.employee.service;

import com.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto ed);

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployees();
}
