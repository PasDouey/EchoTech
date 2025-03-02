<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Professor</title>
</head>
<body>
    <h2>Add New Professor</h2>
    <form action="admin-dashboard" method="post">
        <input type="hidden" name="action" value="addProfessor">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>
        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" required><br><br>
        <input type="submit" value="Add Professor">
    </form>
</body>
</html>