package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public long getTotalEmployees() {
        return employeeRepository.count();
    }

    public double getTotalSalary() {
        return employeeRepository.findAll()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double getAverageSalary() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) return 0.0;
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // Highest salary among all employees
    public double getHighestSalary() {
        return employeeRepository.findAll()
                .stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);
    }

    // Search employees by name or department keyword
    public List<Employee> searchEmployees(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getAllEmployees();
        }
        return employeeRepository.findByNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(keyword, keyword);
    }
}
