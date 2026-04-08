package com.employee.service;

import com.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto ed);

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long empId ,EmployeeDto ed);

    void deleteEmployee(Long id);
}
