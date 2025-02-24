package com.schoolmanagement.test;

import com.schoolmanagement.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}