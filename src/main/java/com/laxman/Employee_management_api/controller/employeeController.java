package com.laxman.Employee_management_api.controller;

import com.laxman.Employee_management_api.model.Employee;
import com.laxman.Employee_management_api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class employeeController {

    private final EmployeeService employeeService;
    public employeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmpolyee(@RequestBody Employee employee){
        Employee newEmployee= employeeService.addEmpolyee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> GetAllEmployee(){
        List<Employee> employees =employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findEmpolyeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeByID(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee) {
        employee.setId(id);
        Employee updateEmployee= employeeService. updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
