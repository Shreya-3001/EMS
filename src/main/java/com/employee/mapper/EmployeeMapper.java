package com.employee.mapper;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee e){

        return new EmployeeDto(
                e.getId(),
                e.getFirstName(),
                e.getLastName(),
                e.getEmail(),
                e.getCreatedDate(),
                e.getUpdatedDate()
        );
    }


    public static Employee mapToEmployee(EmployeeDto ed){

        return new Employee(
                ed.getId(),
                ed.getFirstName(),
                ed.getLastName(),
                ed.getEmail(),
                ed.getCreatedDate(),
                ed.getUpdatedDate()
        );
    }
}
