package com.schoolmanagement.util;
public class TestMySQLDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
