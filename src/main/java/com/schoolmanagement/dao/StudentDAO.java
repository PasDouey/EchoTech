package com.schoolmanagement.dao;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Insert a new student
    public void addStudent(Student student) {
        String sql = "INSERT INTO Student (user_id, first_name, last_name, cne, study_level, status, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getCne());
            ps.setString(5, student.getStudyLevel());
            ps.setString(6, student.getStatus());
            ps.setDate(7, new java.sql.Date(student.getBirthday().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a student by user ID
    public Student getStudentByUserId(int userId) {
        String sql = "SELECT * FROM Student WHERE user_id = ?";
        Student student = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setUserId(rs.getInt("user_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setCne(rs.getString("cne"));
                student.setStudyLevel(rs.getString("study_level"));
                student.setStatus(rs.getString("status"));
                student.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    
    public Student getStudentByUserCne(String cne) {
        String sql = "SELECT * FROM Student WHERE cne = ?";
        Student student = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cne);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setUserId(rs.getInt("user_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setCne(rs.getString("cne"));
                student.setStudyLevel(rs.getString("study_level"));
                student.setStatus(rs.getString("status"));
                student.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setUserId(rs.getInt("user_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setCne(rs.getString("cne"));
                student.setStudyLevel(rs.getString("study_level"));
                student.setStatus(rs.getString("status"));
                student.setBirthday(rs.getDate("birthday"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Update a student
    public void updateStudent(Student student) {
        String sql = "UPDATE Student SET first_name = ?, last_name = ?, cne = ?, study_level = ?, status = ?, birthday = ? WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getCne());
            ps.setString(4, student.getStudyLevel());
            ps.setString(5, student.getStatus());
            ps.setDate(6, new java.sql.Date(student.getBirthday().getTime()));
            ps.setInt(7, student.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a student by user ID
    public void deleteStudent(int userId) {
        String sql = "DELETE FROM Student WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}