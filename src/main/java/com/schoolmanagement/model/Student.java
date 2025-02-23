package com.schoolmanagement.model;

import java.util.Date;

public class Student {
    private int userId; // Foreign key to User
    private String firstName;
    private String lastName;
    private String cne;
    private String studyLevel;
    private String status;
    private Date birthday;

    // Constructors
    public Student() {}

    public Student(int userId, String firstName, String lastName, String cne, String studyLevel, String status, Date birthday) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cne = cne;
        this.studyLevel = studyLevel;
        this.status = status;
        this.birthday = birthday;
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

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}