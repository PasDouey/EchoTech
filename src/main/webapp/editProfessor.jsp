<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> <!-- Ensure EL is enabled -->
<%@ page import="com.schoolmanagement.model.Professor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Professor</title>
</head>
<body>
    <h2>Edit Professor</h2>
    <form action="admin-dashboard" method="post">
        <input type="hidden" name="action" value="editProfessor">
        <input type="hidden" name="userId" value="${professor.userId}">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${professor.firstName}" required><br><br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${professor.lastName}" required><br><br>
        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" step="0.01" value="${professor.salary}" required><br><br>
        <input type="submit" value="Update Professor">
    </form>
</body>
</html>