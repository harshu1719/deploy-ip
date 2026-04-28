package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Search by name or department (case-insensitive)
    List<Employee> findByNameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(String name, String department);
}
