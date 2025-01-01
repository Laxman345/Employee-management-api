package com.laxman.Employee_management_api.service;

import com.laxman.Employee_management_api.exception.EmployeeNotFoundException;
import com.laxman.Employee_management_api.model.Employee;
import com.laxman.Employee_management_api.repository.EmpolyeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Spring Service Component Managing it class and making it accessible for injection into other part of application.

public class EmployeeService {


    @Autowired //To interact seamlessly with database.
    private  EmpolyeeRepo empolyeeRepo;

    public Employee addEmpolyee(Employee employee) {
        return empolyeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return empolyeeRepo.findAll(); //it will return list of all employees in the DataBase.
    }

    public Employee findEmployeeByID(Long id) {
        return empolyeeRepo.findEmployeeById(id)
        .orElseThrow(() -> new EmployeeNotFoundException("Employee by id" + id+ "Was not found"));
    }

    public Employee updateEmployee(Employee employee) {
        return empolyeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = this.empolyeeRepo
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException ("Employee by id" + id+ "Was not found"));
        this.empolyeeRepo.delete(existingEmployee);
    }
}
