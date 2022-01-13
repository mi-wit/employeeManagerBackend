package com.company.connectionSQL.service;

import com.company.connectionSQL.exeption.UserNotFoundException;
import com.company.connectionSQL.model.Employee;
import com.company.connectionSQL.repo.EmployeeRepo;
import com.company.connectionSQL.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final JobRepo jobRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, JobRepo jobRepo) {
        this.employeeRepo = employeeRepo;
        this.jobRepo = jobRepo;
    }

    public Employee addEmployee(Employee employee) {
        this.jobRepo.save(employee.getJob());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Integer id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    @Transactional
    public void deleteEmployee(Integer id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
