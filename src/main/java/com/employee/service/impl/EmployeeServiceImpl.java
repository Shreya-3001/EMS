package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.exception.ResourcesNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public EmployeeDto getEmployee(Long id) {

        Employee e = repo.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee not found with id " + id));
        return EmployeeMapper.mapToEmployeeDto(e);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> empList = repo.findAll();

        return empList.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee)))
                .collect(Collectors.toList());
    }
}
