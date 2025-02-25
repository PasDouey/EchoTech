<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.schoolmanagement.model.User" %>
<%@ page import="com.schoolmanagement.model.Student" %>
<%@ page import="com.schoolmanagement.model.Marks" %>
<%@ page import="com.schoolmanagement.model.Absence" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espace Etudiant</title>
    <link rel="stylesheet" href="css/Etudiant.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <div class="profile">
                <img src="assets/profile_male.svg" alt="Avatar">
                <%
                    User user = (User) session.getAttribute("user");
                    Student student = (Student) request.getAttribute("student");
                    if (student != null) {
                %>
                    <p><%= student.getFirstName() %> <%= student.getLastName() %></p>
                <%
                    } else {
                %>
                    <p>Utilisateur non connecté</p>
                <%
                    }
                %>
            </div>
            <nav>
                <a href="student?section=emploi">Emploi</a>
				<a href="student?section=notes">Notes</a>
				<a href="student?section=absences">Absences</a>

                <a href="logout" class="logout2">Déconnexion</a>
            </nav>
        </aside>
        <main class="content" id="main-content">
            <header>
                <h1 id="section-title"><%= request.getAttribute("sectionTitle") %></h1>
                <hr>
            </header>
            <div id="section-content">
                <!-- Dynamic Content Based on Section -->
                <%
                    String section = (String) request.getAttribute("section");
                    if ("emploi".equals(section)) {
                %>
                    <div style="text-align: center; margin-top: 20px;">
                        <img src="assets/emploi.webp" alt="Emploi du temps" class="emploi-image">
                    </div>
                    <div class="export-button-container">
                        <button class="export-button">
                            <img src="assets/download-small (1).png" alt="Download" class="download-icon">
                            Exporter
                        </button>
                    </div>
                <%
                    } else if ("notes".equals(section)) {
                        List<Marks> grades = (List<Marks>) request.getAttribute("grades");
                        if (grades != null && !grades.isEmpty()) {
                %>
                            <div class="notes-container">
                                <h2>Notes</h2>
                                <table class="notes-table">
                                    <thead>
                                        <tr>
                                            <th>Matière</th>
                                            <th>Note</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (Marks grade : grades) {
                                        %>
                                            <tr>
                                                <td><%= grade.getSubject() %></td>
                                                <td><%= grade.getMark() %></td>
                                            </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                <%
                        } else {
                %>
                            <p>Aucune note disponible.</p>
                <%
                        }
                    } else if ("absences".equals(section)) {
                        List<Absence> absences = (List<Absence>) request.getAttribute("absences");
                        if (absences != null && !absences.isEmpty()) {
                %>
                            <div class="absences-container">
                                <h2>Absences</h2>
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Date</th>
                                            <th>Matière</th>
                                            <th>Justifiée</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (Absence absence : absences) {
                                        %>
                                            <tr>
                                                <td><%= absence.getDate() %></td>
                                                <td><%= absence.getSubject() %></td>
                                                <td><%= absence.isJustified() ? "Oui" : "Non" %></td>
                                            </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                <%
                        } else {
                %>
                            <p>Aucune absence enregistrée.</p>
                <%
                        }
                    }
                %>
            </div>
        </main>
    </div>
</body>
</html>
