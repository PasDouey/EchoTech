<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.schoolmanagement.dao.*, com.schoolmanagement.model.*, java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/admin.css">
</head>

<body>

    <header>
        <h1>Admin Dashboard</h1>
        <nav>
            <ul>
                <li><a href="admin-dashboard?action=viewProfessors">Professors</a></li>
                <li><a href="admin-dashboard?action=viewStudents">Students</a></li>
                <li><a href="admin-dashboard?action=viewAbsences">Absences</a></li>
                <li><a href="admin-dashboard?action=viewMarks">Marks</a></li>
                <li><a href="admin-dashboard?action=viewTimetable">Timetable</a></li>
            </ul>
        </nav>
    </header>

    <section>
        <%
            String action = (String) request.getAttribute("action");
            if ("viewProfessors".equals(action)) {
                List<Professor> professors = (List<Professor>) request.getAttribute("professors");
        %>
                <h2>Professors</h2>
                <a href="admin-dashboard?action=addProfessor">Add New Professor</a>
                <table>
                    <tr>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Salary</th>
                        <th>Actions</th>
                    </tr>
                    <% for (Professor professor : professors) { %>
                        <tr>
                            <td><%= professor.getUserId() %></td>
                            <td><%= professor.getFirstName() %></td>
                            <td><%= professor.getLastName() %></td>
                            <td><%= professor.getSalary() %></td>
                            <td>
                                <a href="admin-dashboard?action=editProfessor&id=<%= professor.getUserId() %>">Edit</a> | 
                                <a href="admin-dashboard?action=deleteProfessor&id=<%= professor.getUserId() %>">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
        <%
            } else if ("viewStudents".equals(action)) {
                List<Student> students = (List<Student>) request.getAttribute("students");
        %>
                <h2>Students</h2>
                <a href="admin-dashboard?action=addStudent">Add New Student</a>
                <table>
                    <tr>
                        <th>User ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>CNE</th>
                        <th>Study Level</th>
                        <th>Status</th>
                        <th>Birthday</th>
                        <th>Actions</th>
                    </tr>
                    <% for (Student student : students) { %>
                        <tr>
                            <td><%= student.getUserId() %></td>
                            <td><%= student.getFirstName() %></td>
                            <td><%= student.getLastName() %></td>
                            <td><%= student.getCne() %></td>
                            <td><%= student.getStudyLevel() %></td>
                            <td><%= student.getStatus() %></td>
                            <td><%= student.getBirthday() %></td>
                            <td>
                                <a href="admin-dashboard?action=editStudent&id=<%= student.getUserId() %>">Edit</a> | 
                                <a href="admin-dashboard?action=deleteStudent&id=<%= student.getUserId() %>">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
        <%
            } else if ("viewAbsences".equals(action)) {
                List<Absence> absences = (List<Absence>) request.getAttribute("absences");
        %>
                <h2>Absences</h2>
                <a href="admin-dashboard?action=addAbsence">Add New Absence</a>
                <table>
                    <tr>
                        <th>Absence ID</th>
                        <th>Student ID</th>
                        <th>Class ID</th>
                        <th>Date</th>
                        <th>Justified</th>
                        <th>Actions</th>
                    </tr>
                    <% for (Absence absence : absences) { %>
                        <tr>
                            <td><%= absence.getId() %></td>
                            <td><%= absence.getStudentId() %></td>
                            <td><%= absence.getClassId() %></td>
                            <td><%= absence.getDate() %></td>
                            <td><%= absence.isJustified() %></td>
                            <td>
                                <a href="admin-dashboard?action=editAbsence&id=<%= absence.getId() %>">Edit</a> | 
                                <a href="admin-dashboard?action=deleteAbsence&id=<%= absence.getId() %>">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
        <%
            } else if ("viewMarks".equals(action)) {
                List<Marks> marks = (List<Marks>) request.getAttribute("marks");
        %>
                <h2>Marks</h2>
                <a href="admin-dashboard?action=addMark">Add New Mark</a>
                <table>
                    <tr>
                        <th>Student ID</th>
                        <th>Class ID</th>
                        <th>Mark</th>
                        <th>Actions</th>
                    </tr>
                    <% for (Marks mark : marks) { %>
                        <tr>
                            <td><%= mark.getStudentId() %></td>
                            <td><%= mark.getClassId() %></td>
                            <td><%= mark.getMark() %></td>
                            <td>
                                <a href="admin-dashboard?action=editMark&id=<%= mark.getStudentId() %>">Edit</a> | 
                                <a href="admin-dashboard?action=deleteMark&id=<%= mark.getStudentId() %>">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
        <%
            } else if ("viewTimetable".equals(action)) {
                List<Timetable> timetable = (List<Timetable>) request.getAttribute("timetable");
        %>
                <h2>Timetable</h2>
                <a href="admin-dashboard?action=addTimetable">Add New Timetable</a>
                <table>
                    <tr>
                        <th>Time Slot</th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Actions</th>
                    </tr>
                    <% for (Timetable slot : timetable) { %>
                        <tr>
                            <td><%= slot.getTimeSlot() %></td>
                            <td><%= slot.getMonday() %></td>
                            <td><%= slot.getTuesday() %></td>
                            <td><%= slot.getWednesday() %></td>
                            <td><%= slot.getThursday() %></td>
                            <td><%= slot.getFriday() %></td>
                            <td>
                                <a href="admin-dashboard?action=editTimetable&timeSlot=<%= slot.getTimeSlot() %>">Edit</a> | 
                                <a href="admin-dashboard?action=deleteTimetable&timeSlot=<%= slot.getTimeSlot() %>">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
        <%
            }
        %>
    </section>

</body>
</html>