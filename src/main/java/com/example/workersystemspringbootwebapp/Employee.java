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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
