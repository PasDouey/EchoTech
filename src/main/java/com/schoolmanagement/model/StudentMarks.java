package com.schoolmanagement.model;

public class StudentMarks {
    private Marks marks; // The Marks object
    private String studentName; // The student name

    // Constructor
    public StudentMarks(Marks marks, String studentName) {
        this.marks = marks;
        this.studentName = studentName;
    }

    // Getters and Setters
    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
