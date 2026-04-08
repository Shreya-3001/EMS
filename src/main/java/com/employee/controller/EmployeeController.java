package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id){

        EmployeeDto ed = empImpl.getEmployee(id);


        return ResponseEntity.ok(ed);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> emps = empImpl.getAllEmployees();
        return ResponseEntity.ok(emps);
    }


}
