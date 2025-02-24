package com.schoolmanagement.model;

public class Class {
    private int id;
    private String name;
    private int professorId; // Foreign key to Professor
    private int year;

    // Constructors
    public Class() {}

    public Class(int id, String name, int professorId, int year) {
        this.id = id;
        this.name = name;
        this.professorId = professorId;
        this.year = year;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}