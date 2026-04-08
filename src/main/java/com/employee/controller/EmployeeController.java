package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl empImpl;

    //to add employee
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto ed){

        EmployeeDto saveEmp = empImpl.createEmployee(ed);

        return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
    }

}
