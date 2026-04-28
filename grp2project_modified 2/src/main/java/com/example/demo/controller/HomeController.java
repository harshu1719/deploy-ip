package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.EmployeeService;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final EmployeeService employeeService;

    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalEmployees", employeeService.getTotalEmployees());
        model.addAttribute("totalSalary", employeeService.getTotalSalary());
        model.addAttribute("avgSalary", employeeService.getAverageSalary());
        model.addAttribute("highestSalary", employeeService.getHighestSalary());
        return "index";
    }
}
