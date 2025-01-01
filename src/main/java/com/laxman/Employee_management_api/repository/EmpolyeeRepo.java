package com.laxman.Employee_management_api.repository;
import com.laxman.Employee_management_api.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //Tells Spring to manage this interface as spring to manage this as a spring beam making it injectable into other parts of application.
public interface EmpolyeeRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findEmployeeById(Long id);
}
