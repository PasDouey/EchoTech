package com.schoolmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanagement.model.Timetable;
import com.schoolmanagement.util.DatabaseUtil;

public class TimetableDAO {

    private static final String GET_TIMETABLE_QUERY = 
        "SELECT time_slot, monday, tuesday, wednesday, thursday, friday " +
        "FROM timetable ORDER BY time_slot";
    
 

        private static final String ADD_TIMETABLE_QUERY = 
            "INSERT INTO timetable (time_slot, monday, tuesday, wednesday, thursday, friday) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        private static final String UPDATE_TIMETABLE_QUERY = 
            "UPDATE timetable SET monday = ?, tuesday = ?, wednesday = ?, thursday = ?, friday = ? " +
            "WHERE time_slot = ?";

        private static final String DELETE_TIMETABLE_QUERY = 
            "DELETE FROM timetable WHERE time_slot = ?";

        // Get timetable for a student
        public List<Timetable> getTimetableForStudent(int studentId) {
            List<Timetable> timetable = new ArrayList<>();

            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(GET_TIMETABLE_QUERY)) {

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Timetable slot = new Timetable();
                    slot.setTimeSlot(resultSet.getString("time_slot"));
                    slot.setMonday(resultSet.getString("monday"));
                    slot.setTuesday(resultSet.getString("tuesday"));
                    slot.setWednesday(resultSet.getString("wednesday"));
                    slot.setThursday(resultSet.getString("thursday"));
                    slot.setFriday(resultSet.getString("friday"));

                    timetable.add(slot);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return timetable;
        }

        // Add a new timetable
        public void addTimetable(Timetable timetable) {
            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement deleteStatement = connection.prepareStatement(DELETE_TIMETABLE_QUERY);
                 PreparedStatement insertStatement = connection.prepareStatement(ADD_TIMETABLE_QUERY)) {

                // Delete the existing timetable for the time slot
                deleteStatement.setString(1, timetable.getTimeSlot());
                deleteStatement.executeUpdate();

                // Insert the new timetable
                insertStatement.setString(1, timetable.getTimeSlot());
                insertStatement.setString(2, timetable.getMonday());
                insertStatement.setString(3, timetable.getTuesday());
                insertStatement.setString(4, timetable.getWednesday());
                insertStatement.setString(5, timetable.getThursday());
                insertStatement.setString(6, timetable.getFriday());
                insertStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Update an existing timetable
        public void updateTimetable(Timetable timetable) {
            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement deleteStatement = connection.prepareStatement(DELETE_TIMETABLE_QUERY);
                 PreparedStatement updateStatement = connection.prepareStatement(UPDATE_TIMETABLE_QUERY)) {

                // Delete the existing timetable for the time slot
                deleteStatement.setString(1, timetable.getTimeSlot());
                deleteStatement.executeUpdate();

                // Update the timetable
                updateStatement.setString(1, timetable.getMonday());
                updateStatement.setString(2, timetable.getTuesday());
                updateStatement.setString(3, timetable.getWednesday());
                updateStatement.setString(4, timetable.getThursday());
                updateStatement.setString(5, timetable.getFriday());
                updateStatement.setString(6, timetable.getTimeSlot());
                updateStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Delete a timetable by time slot
        public void deleteTimetable(String timeSlot) {
            try (Connection connection = DatabaseUtil.getConnection();
                 PreparedStatement deleteStatement = connection.prepareStatement(DELETE_TIMETABLE_QUERY)) {

                deleteStatement.setString(1, timeSlot);
                deleteStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    
    public List<Timetable> getTimetableForProfessor() {
        List<Timetable> timetable = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_TIMETABLE_QUERY)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Timetable slot = new Timetable();
                slot.setTimeSlot(resultSet.getString("time_slot"));
                slot.setMonday(resultSet.getString("monday"));
                slot.setTuesday(resultSet.getString("tuesday"));
                slot.setWednesday(resultSet.getString("wednesday"));
                slot.setThursday(resultSet.getString("thursday"));
                slot.setFriday(resultSet.getString("friday"));

                timetable.add(slot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return timetable;
    }
    
    
}
