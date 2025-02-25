package com.schoolmanagement.model;
import com.schoolmanagement.dao.ClassDAO;

import java.util.Date;

public class Absence {
    private int id;
    private int studentId;
    private int classId;
    private Date date;
    private boolean justified;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isJustified() {
        return justified;
    }

    public void setJustified(boolean justified) {
        this.justified = justified;
    }
    
    public String getSubject() {
    	ClassDAO cdo = new ClassDAO();
    	return cdo.getClassById(this.classId).getName();
    }
}