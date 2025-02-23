package com.schoolmanagement.dao;

import com.schoolmanagement.model.Professor;
import com.schoolmanagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    // Insert a new professor
    public void addProfessor(Professor professor) {
        String sql = "INSERT INTO Professor (user_id, first_name, last_name, cni, employment_date, salary) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, professor.getUserId());
            ps.setString(2, professor.getFirstName());
            ps.setString(3, professor.getLastName());
            ps.setString(4, professor.getCni());
            ps.setDate(5, new java.sql.Date(professor.getEmploymentDate().getTime()));
            ps.setDouble(6, professor.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a professor by user ID
    public Professor getProfessorByUserId(int userId) {
        String sql = "SELECT * FROM Professor WHERE user_id = ?";
        Professor professor = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                professor = new Professor();
                professor.setUserId(rs.getInt("user_id"));
                professor.setFirstName(rs.getString("first_name"));
                professor.setLastName(rs.getString("last_name"));
                professor.setCni(rs.getString("cni"));
                professor.setEmploymentDate(rs.getDate("employment_date"));
                professor.setSalary(rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professor;
    }

    // Get all professors
    public List<Professor> getAllProfessors() {
        List<Professor> professors = new ArrayList<>();
        String sql = "SELECT * FROM Professor";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setUserId(rs.getInt("user_id"));
                professor.setFirstName(rs.getString("first_name"));
                professor.setLastName(rs.getString("last_name"));
                professor.setCni(rs.getString("cni"));
                professor.setEmploymentDate(rs.getDate("employment_date"));
                professor.setSalary(rs.getDouble("salary"));
                professors.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professors;
    }

    // Update a professor
    public void updateProfessor(Professor professor) {
        String sql = "UPDATE Professor SET first_name = ?, last_name = ?, cni = ?, employment_date = ?, salary = ? WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, professor.getFirstName());
            ps.setString(2, professor.getLastName());
            ps.setString(3, professor.getCni());
            ps.setDate(4, new java.sql.Date(professor.getEmploymentDate().getTime()));
            ps.setDouble(5, professor.getSalary());
            ps.setInt(6, professor.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a professor by user ID
    public void deleteProfessor(int userId) {
        String sql = "DELETE FROM Professor WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}