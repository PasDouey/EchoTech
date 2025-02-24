package com.schoolmanagement.dao;

import com.schoolmanagement.model.Marks;
import com.schoolmanagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    // Insert a new mark
    public void addMark(Marks mark) {
        String sql = "INSERT INTO Marks (student_id, class_id, mark) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, mark.getStudentId());
            ps.setInt(2, mark.getClassId());
            ps.setDouble(3, mark.getMark());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get marks by student ID
    public List<Marks> getMarksByStudentId(int studentId) {
        List<Marks> marks = new ArrayList<>();
        String sql = "SELECT * FROM Marks WHERE student_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Marks mark = new Marks();
                mark.setStudentId(rs.getInt("student_id"));
                mark.setClassId(rs.getInt("class_id"));
                mark.setMark(rs.getDouble("mark"));
                marks.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marks;
    }

    // Get marks by class ID
    public List<Marks> getMarksByClassId(int classId) {
        List<Marks> marks = new ArrayList<>();
        String sql = "SELECT * FROM Marks WHERE class_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, classId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Marks mark = new Marks();
                mark.setStudentId(rs.getInt("student_id"));
                mark.setClassId(rs.getInt("class_id"));
                mark.setMark(rs.getDouble("mark"));
                marks.add(mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marks;
    }

    // Update a mark
    public void updateMark(Marks mark) {
        String sql = "UPDATE Marks SET mark = ? WHERE student_id = ? AND class_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, mark.getMark());
            ps.setInt(2, mark.getStudentId());
            ps.setInt(3, mark.getClassId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a mark
    public void deleteMark(int studentId, int classId) {
        String sql = "DELETE FROM Marks WHERE student_id = ? AND class_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, classId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}