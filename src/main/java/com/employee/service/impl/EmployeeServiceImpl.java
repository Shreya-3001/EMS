package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto ed) {

        Employee e = EmployeeMapper.mapToEmployee(ed);

        e.setCreatedDate(new Date());

        Employee savedEmp=repo.save(e);

        return EmployeeMapper.mapToEmployeeDto(savedEmp);
    }
}
