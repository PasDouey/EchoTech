package com.schoolmanagement.model;

import java.util.Date;

public class Professor {
    private int userId; // Foreign key to User
    private String firstName;
    private String lastName;
    private String cni;
    private Date employmentDate;
    private double salary;

    // Constructors
    public Professor() {}

    public Professor(int userId, String firstName, String lastName, String cni, Date employmentDate, double salary) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cni = cni;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}