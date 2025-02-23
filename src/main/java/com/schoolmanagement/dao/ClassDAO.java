package com.schoolmanagement.dao;

import com.schoolmanagement.model.Class;
import com.schoolmanagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

    // Insert a new class
    public void addClass(Class clazz) {
        String sql = "INSERT INTO Class (name, professor_id, year) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clazz.getName());
            ps.setInt(2, clazz.getProfessorId());
            ps.setInt(3, clazz.getYear());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a class by ID
    public Class getClassById(int id) {
        String sql = "SELECT * FROM Class WHERE id = ?";
        Class clazz = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clazz = new Class();
                clazz.setId(rs.getInt("id"));
                clazz.setName(rs.getString("name"));
                clazz.setProfessorId(rs.getInt("professor_id"));
                clazz.setYear(rs.getInt("year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    // Get all classes
    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM Class";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Class clazz = new Class();
                clazz.setId(rs.getInt("id"));
                clazz.setName(rs.getString("name"));
                clazz.setProfessorId(rs.getInt("professor_id"));
                clazz.setYear(rs.getInt("year"));
                classes.add(clazz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    // Update a class
    public void updateClass(Class clazz) {
        String sql = "UPDATE Class SET name = ?, professor_id = ?, year = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, clazz.getName());
            ps.setInt(2, clazz.getProfessorId());
            ps.setInt(3, clazz.getYear());
            ps.setInt(4, clazz.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a class by ID
    public void deleteClass(int id) {
        String sql = "DELETE FROM Class WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}