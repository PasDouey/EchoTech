package com.schoolmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.schoolmanagement.model.Timetable;
import com.schoolmanagement.util.DatabaseUtil;

public class TimetableDAO {

    private static final String GET_TIMETABLE_QUERY = 
        "SELECT time_slot, monday, tuesday, wednesday, thursday, friday " +
        "FROM timetable ORDER BY time_slot";

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
