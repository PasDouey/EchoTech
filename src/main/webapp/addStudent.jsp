<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
</head>
<body>
    <h2>Add New Student</h2>
    <form action="admin-dashboard" method="post">
        <input type="hidden" name="action" value="addStudent">
        <label for="userId">User ID:</label>
        <input type="number" id="userId" name="userId" required><br><br>
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br><br>
        <label for="cne">CNE:</label>
        <input type="text" id="cne" name="cne" required><br><br>
        <label for="studyLevel">Study Level:</label>
        <input type="text" id="studyLevel" name="studyLevel" required><br><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" required><br><br>
        <label for="birthday">Birthday:</label>
        <input type="date" id="birthday" name="birthday" required><br><br>
        <input type="submit" value="Add Student">
    </form>
</body>
</html>