package com.schoolmanagement.dao;

import com.schoolmanagement.model.Absence;
import com.schoolmanagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbsenceDAO {

    // Insert a new absence record
    public void addAbsence(Absence absence) {
        String sql = "INSERT INTO Absences (student_id, class_id, date, justified) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, absence.getStudentId());
            ps.setInt(2, absence.getClassId());
            ps.setDate(3, new java.sql.Date(absence.getDate().getTime()));
            ps.setBoolean(4, absence.isJustified());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Absence> getAllAbsences(){
    	List<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM Absences ";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Absence absence = new Absence();
                absence.setId(rs.getInt("id"));
                absence.setStudentId(rs.getInt("student_id"));
                absence.setClassId(rs.getInt("class_id"));
                absence.setDate(rs.getDate("date"));
                absence.setJustified(rs.getBoolean("justified"));
                absences.add(absence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absences;
    }

    // Get all absences for a specific student
    public List<Absence> getAbsencesByStudentId(int studentId) {
        List<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM Absences WHERE student_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Absence absence = new Absence();
                absence.setId(rs.getInt("id"));
                absence.setStudentId(rs.getInt("student_id"));
                absence.setClassId(rs.getInt("class_id"));
                absence.setDate(rs.getDate("date"));
                absence.setJustified(rs.getBoolean("justified"));
                absences.add(absence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absences;
    }

    // Get all absences for a specific class
    public static List<Absence> getAbsencesByClassId(int classId) {
        List<Absence> absences = new ArrayList<>();
        String sql = "SELECT a.id, a.student_id, u.first_name, u.last_name, a.class_id, a.date, c.name as subject, a.justified " +
                     "FROM Absences a " +
                     "JOIN student u ON a.student_id = u.user_id " +
                     "JOIN class c ON c.id = a.class_id "+
                     "WHERE a.class_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, classId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Absence absence = new Absence();
                absence.setId(rs.getInt("id"));
                absence.setStudentId(rs.getInt("student_id"));
                absence.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name")); // Set student name
                absence.setClassId(rs.getInt("class_id"));
                absence.setDate(rs.getDate("date"));
                absence.setSubject(rs.getString("subject"));
                absence.setJustified(rs.getBoolean("justified"));
                absences.add(absence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absences;
    }
    // Update an absence record
    public void updateAbsence(Absence absence) {
        String sql = "UPDATE Absences SET student_id = ?, class_id = ?, date = ?, justified = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, absence.getStudentId());
            ps.setInt(2, absence.getClassId());
            ps.setDate(3, new java.sql.Date(absence.getDate().getTime()));
            ps.setBoolean(4, absence.isJustified());
            ps.setInt(5, absence.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an absence record by ID
    public void deleteAbsence(int absenceId) {
        String sql = "DELETE FROM Absences WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, absenceId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}