<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Timetable</title>
</head>
<body>
    <h2>Add New Timetable</h2>
    <form action="admin-dashboard" method="post">
        <input type="hidden" name="action" value="addTimetable">
        <label for="timeSlot">Time Slot:</label>
        <input type="text" id="timeSlot" name="timeSlot" required><br><br>
        <label for="monday">Monday:</label>
        <input type="text" id="monday" name="monday" required><br><br>
        <label for="tuesday">Tuesday:</label>
        <input type="text" id="tuesday" name="tuesday" required><br><br>
        <label for="wednesday">Wednesday:</label>
        <input type="text" id="wednesday" name="wednesday" required><br><br>
        <label for="thursday">Thursday:</label>
        <input type="text" id="thursday" name="thursday" required><br><br>
        <label for="friday">Friday:</label>
        <input type="text" id="friday" name="friday" required><br><br>
        <input type="submit" value="Add Timetable">
    </form>
</body>
</html>