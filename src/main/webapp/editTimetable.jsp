<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> <!-- Ensure EL is enabled -->
<%@ page import="com.schoolmanagement.model.Timetable" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Timetable</title>
</head>
<body>
    <h2>Edit Timetable</h2>
    <form action="admin-dashboard" method="post">
        <input type="hidden" name="action" value="editTimetable">
        <label for="timeSlot">Time Slot:</label>
        <input type="text" id="timeSlot" name="timeSlot" value="${timetable.timeSlot}" required><br><br>
        <label for="monday">Monday:</label>
        <input type="text" id="monday" name="monday" value="${timetable.monday}" required><br><br>
        <label for="tuesday">Tuesday:</label>
        <input type="text" id="tuesday" name="tuesday" value="${timetable.tuesday}" required><br><br>
        <label for="wednesday">Wednesday:</label>
        <input type="text" id="wednesday" name="wednesday" value="${timetable.wednesday}" required><br><br>
        <label for="thursday">Thursday:</label>
        <input type="text" id="thursday" name="thursday" value="${timetable.thursday}" required><br><br>
        <label for="friday">Friday:</label>
        <input type="text" id="friday" name="friday" value="${timetable.friday}" required><br><br>
        <input type="submit" value="Update Timetable">
    </form>
</body>
</html>