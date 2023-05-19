package com.example.workersystemspringbootwebapp;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerController {

    private List<Employee> employees = new ArrayList<>();
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employees);
        return "index";
    }
}
