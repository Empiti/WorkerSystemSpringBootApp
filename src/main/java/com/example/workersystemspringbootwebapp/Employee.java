package com.example.workersystemspringbootwebapp;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(int id, String name, String lastName, String position, int salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }
}
