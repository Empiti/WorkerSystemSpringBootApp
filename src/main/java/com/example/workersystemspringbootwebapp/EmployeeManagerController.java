package com.example.workersystemspringbootwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
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

    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Employee employee = findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-form";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, @ModelAttribute Employee updatedEmployee) {
        Employee employee = findEmployeeById(id);
        employee.setPosition(updatedEmployee.getPosition());
        employee.setSalary(updatedEmployee.getSalary());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        Employee employee = findEmployeeById(id);
        employees.remove(employee);
        return "redirect:/";
    }

    private List<Employee> findEmployeesByLastName(String lastName) {
        List<Employee> matchingEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam("lastName") String lastName, Model model) {
        List<Employee> matchingEmployees = findEmployeesByLastName(lastName);
        model.addAttribute("employees", matchingEmployees);
        return "index";
    }


}
