<%@ page import="com.schoolmanagement.model.Professor" %>
<%@ page import="com.schoolmanagement.model.Marks" %>
<%@ page import="com.schoolmanagement.model.Absence" %>
<%@ page import="com.schoolmanagement.model.Timetable" %>
<%@ page import="com.schoolmanagement.model.StudentMarks" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espace Enseignant</title>
    <link rel="stylesheet" href="css/Enseignant.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <div class="profile">
                <img src="assets/profile_male.svg" alt="Avatar">
                <%
                    Professor professor = (Professor) request.getAttribute("professor");
                    if (professor != null) {
                %>
                    <p><%= professor.getFirstName() %> <%= professor.getLastName() %></p>
                <%
                    } else {
                %>
                    <p>Utilisateur non connecté</p>
                <%
                    }
                %>
            </div>
            <nav>
                <!-- Dropdown for selecting class, ensuring class is passed with each section -->
                <form action="professor" method="get">
                    <select name="classSelection" onchange="this.form.submit()">
                        <%
                            List<String> classes = (List<String>) request.getAttribute("classes");
                            String selectedClass = (String) request.getAttribute("selectedClass");
                            for (String c : classes) {
                        %>
                            <option value="<%= c %>" <%= c.equals(selectedClass) ? "selected" : "" %>><%= c %></option>
                        <%
                            }
                        %>
                    </select>
                </form>
                <a href="professor?section=emploi&classSelection=<%= request.getAttribute("selectedClass") %>">Emploi</a>
                <a href="professor?section=notes&classSelection=<%= request.getAttribute("selectedClass") %>">Notes</a>
                <a href="professor?section=absences&classSelection=<%= request.getAttribute("selectedClass") %>">Absences</a>
                <a href="logout" class="logout2">Déconnexion</a>
            </nav>
        </aside>
        <main class="content">
            <header>
                <h1 id="section-title"><%= request.getAttribute("sectionTitle") %></h1>
                <hr>
            </header>
            <div id="section-content">
                <!-- Dynamic Content Based on Section -->
                <%
                    String section = (String) request.getAttribute("section");
                    if ("emploi".equals(section)) {
                        List<Timetable> timetable = (List<Timetable>) request.getAttribute("timetable");
                        if (timetable != null && !timetable.isEmpty()) {
                %>
                            <div style="text-align: center; margin-top: 20px;">
                                <div class="custom-timetable-container">
                                    <h2 class="custom-timetable-title">Emploi du Temps</h2>
                                    <table class="custom-timetable">
                                        <thead>
                                            <tr>
                                                <th>Horaires</th>
                                                <th>Lundi</th>
                                                <th>Mardi</th>
                                                <th>Mercredi</th>
                                                <th>Jeudi</th>
                                                <th>Vendredi</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (Timetable row : timetable) {
                                            %>
                                                <tr>
                                                    <td><%= row.getTimeSlot() %></td>
                                                    <td><%= row.getMonday() %></td>
                                                    <td><%= row.getTuesday() %></td>
                                                    <td><%= row.getWednesday() %></td>
                                                    <td><%= row.getThursday() %></td>
                                                    <td><%= row.getFriday() %></td>
                                                </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                <%
                        } else {
                %>
                            <p>Aucun emploi du temps disponible.</p>
                <%
                        }
                %>
                       <!-- <div class="export-button-container">
                            <button class="export-button">
                                <img src="assets/download-small (1).png" alt="Download" class="download-icon">
                                Exporter
                            </button>
                        </div> -->
                <%
                    } else if ("notes".equals(section)) {
                        List<StudentMarks> studentMarksList = (List<StudentMarks>) request.getAttribute("studentMarksList");
                        if (studentMarksList != null && !studentMarksList.isEmpty()) {
                %>
                            <div class="notes-container">
                                <h2>Notes</h2>
                                <table class="notes-table">
                                    <thead>
                                        <tr>
                                            <th>Élève</th>
                                            <th>Matière</th>
                                            <th>Note</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (StudentMarks studentMarks : studentMarksList) {
                                        %>
                                            <tr>
                                                <td><%= studentMarks.getStudentName() %></td>
                                                <td><%= studentMarks.getMarks().getSubject() %></td>
                                                <td><%= studentMarks.getMarks().getMark() %></td>
                                            </tr>
                                        <%
                                            }
                                        %>
                                        <tr>
                                        	<form action="professor" method = "post">
                                        	<input type="hidden" name="classSelection" value="<%= request.getAttribute("selectedClass") %>">
    										<input type="hidden" name="section" value="<%= request.getAttribute("section") %>">
    										<td>
                                        		<input type="text" name="studentcne" placeholder="Cne de l'étudiant">
                                        		</td>
                                        		<td>
                                        			<%= request.getAttribute("selectedClass") %>
                                        			<input type="hidden" name="classId" value="<%= request.getAttribute("classId") %>">
                                        		</td>
                                        		<td>
                                        			<input type="text" name="mark" placeholder="note">
                                        		</td>
                                        			
                                        		
                                        		
                                        		<td>
                                        			<input type="submit" value="ajouter">
                                        		</td>
                                        	</form>
                                        </tr>
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
                                <a href="">Ajouter une abscence </a>
                                <table class="abscence-table">
                                    <thead>
                                        <tr>
                                            <th>Élève</th> <!-- New column for student name -->
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
					                            <td><%= absence.getStudentName() %></td> <!-- Display student name -->
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
