<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> <!-- Ensure EL is enabled -->
<%@ page import="com.schoolmanagement.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student</h2>
    <form action="admin-dashboard" method="post">
        <input type="hidden" name="action" value="editStudent">
        <input type="hidden" name="userId" value="${student.userId}">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${student.firstName}" required><br><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${student.lastName}" required><br><br>
        <label for="cne">CNE:</label>
        <input type="text" id="cne" name="cne" value="${student.cne}" required><br><br>
        <label for="studyLevel">Study Level:</label>
        <input type="text" id="studyLevel" name="studyLevel" value="${student.studyLevel}" required><br><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" value="${student.status}" required><br><br>
        <label for="birthday">Birthday:</label>
        <input type="date" id="birthday" name="birthday" value="${student.birthday}" required><br><br>
        <input type="submit" value="Update Student">
    </form>
</body>
</html>