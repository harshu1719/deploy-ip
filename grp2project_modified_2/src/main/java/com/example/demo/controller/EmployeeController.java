package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Employee list with optional search keyword
    @GetMapping("/employees")
    public String viewHomePage(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Employee> employees = employeeService.searchEmployees(search);

        model.addAttribute("employees", employees);
        model.addAttribute("totalEmployees", employees.size());
        model.addAttribute("totalSalary", employeeService.getTotalSalary());
        model.addAttribute("avgSalary", employeeService.getAverageSalary());
        model.addAttribute("highestSalary", employeeService.getHighestSalary());
        model.addAttribute("search", search != null ? search : "");

        return "employee-list";
    }

    // Delete employee — fixed redirect to /employees
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // Show add employee form
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    // Save employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    // Show edit employee form
    @GetMapping("/showEditEmployeeForm/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }
}
