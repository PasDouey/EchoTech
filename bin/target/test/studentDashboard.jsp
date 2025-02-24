<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.schoolmanagement.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .dashboard-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .dashboard-container h2 {
            margin-bottom: 20px;
        }
        .dashboard-container a {
            display: inline-block;
            margin-top: 15px;
            color: #28a745;
            text-decoration: none;
        }
        .dashboard-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h2>Welcome, Student <%= ((User) session.getAttribute("user")).getEmail() %>!</h2>
        <p>You have successfully logged in as a student.</p>
        <a href="logout">Logout</a>
    </div>
</body>
</html>