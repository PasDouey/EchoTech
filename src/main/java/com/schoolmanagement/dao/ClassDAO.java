package com.schoolmanagement.dao;

import com.schoolmanagement.model.Class;
import com.schoolmanagement.model.Marks;
import com.schoolmanagement.model.Absence;
import com.schoolmanagement.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    
    public List<Class> getClassesByProfessorId(int id) {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM Class WHERE professor_id = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id); // Définition du paramètre
            
            try (ResultSet rs = ps.executeQuery()) { // Exécution après définition du paramètre
                while (rs.next()) {
                	Class c = new Class(rs.getInt("id"),rs.getString("name"),id,rs.getInt("year"));
                    classes.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return classes;
    }
    
    public List<Marks> getMarksByClassId(int class_id){
    	List<Marks> classes = new ArrayList<>();
        String sql = "SELECT * FROM Marks m JOIN Class c ON c.id=m.class_id  WHERE c.id = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
        	ps.setInt(1, class_id);
            
            try (ResultSet rs = ps.executeQuery()) { // Exécution après définition du paramètre
                while (rs.next()) {
                	Marks m = new Marks();
                	m.setClassId(class_id);
                	m.setMark( rs.getDouble("mark"));
                	m.setStudentId(rs.getInt("student_id"));
                    classes.add(m);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return classes;
    
    }
    
    public List<Absence> getAbsencesByClassId(int id) {
        List<Absence> absences = new ArrayList<>();
        String sql = "SELECT * FROM Absence WHERE class_id = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) { // Exécution après définition du paramètre
                while (rs.next()) {
                    Absence a = new Absence();
                    a.setClassId(id);
                    a.setDate(rs.getDate("date"));
                    a.setStudentId(rs.getInt("student_id"));
                    a.setJustified(rs.getBoolean("justified"));
                    absences.add(a);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return absences;
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
    
    
    public Map<String, String> getStudentDetailsByMarks(List<Marks> marksList) {
        Map<String, String> studentDetailsMap = new HashMap<>();
        String sql = "SELECT c.name as subject, s.first_name, s.last_name, s.cne, m.mark " +
                     "FROM marks m " +
                     "JOIN student s ON m.student_id = s.user_id " +
                     "JOIN class c ON m.class_id = c.id " +
                     "WHERE m.student_id = ? AND m.class_id=?";

        for (Marks mark : marksList) {
            try (Connection conn = DatabaseUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
            	System.out.println(mark);
                stmt.setInt(1, mark.getStudentId());
                stmt.setInt(2, mark.getClassId());

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String studentName = rs.getString("first_name") + " " + rs.getString("last_name");
                    String cne = rs.getString("cne");
                    String subject = rs.getString("subject");

                    String studentDetail = studentName + " (CNE: " + cne +")" ;

                    studentDetailsMap.put(subject, studentDetail);
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentDetailsMap;
    }
    public String getStudentNameById(int studentId) {
        String studentName = null;
        String sql = "SELECT first_name, last_name FROM student WHERE user_id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                studentName = firstName + " " + lastName;  // Concatenate first and last name
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return studentName;
    }

}