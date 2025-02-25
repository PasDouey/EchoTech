package com.schoolmanagement.model;
import com.schoolmanagement.model.Class;
import com.schoolmanagement.dao.ClassDAO;
public class Marks {
    private int studentId; // Foreign key to Student
    private int classId;   // Foreign key to Class
    private double mark;

    // Constructors
    public Marks() {}

    public Marks(int studentId, int classId, double mark) {
        this.studentId = studentId;
        this.classId = classId;
        this.mark = mark;
    }

    // Getters and Setters
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

    public double getMark() {
        return mark;
    }
    
    public String getSubject() {
    	ClassDAO cdao = new ClassDAO();
    	Class c = cdao.getClassById(this.classId); 
        return c!=null?  c.getName() : "uknown";
    }
    
    public void setMark(double mark) {
        this.mark = mark;
    }
    
    @Override
    public String toString() {
        return "Marks{" +
                "studentId=" + studentId +
                ", classId=" + classId +
                ", mark=" + mark +
                ", subject='" + getSubject() + "'" +
                '}';
    }
}