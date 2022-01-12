package com.company.connectionSQL.repo;

import com.company.connectionSQL.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    void deleteEmployeeById(Integer id);

    Optional<Employee> findEmployeeById(Integer id);
}
