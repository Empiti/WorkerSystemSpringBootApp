package com.example.workersystemspringbootwebapp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerController {

    private List<Employee> employees = new ArrayList<>();
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employees);
        return "index";
    }
    private int id = 1;
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employee.setId(id++);
        employees.add(employee);
        return "redirect:/";
    }
}
