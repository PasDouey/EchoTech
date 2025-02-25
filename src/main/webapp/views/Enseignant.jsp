<%@ page import="com.schoolmanagement.model.Professor" %>
<%@ page import="com.schoolmanagement.model.Marks" %>
<%@ page import="com.schoolmanagement.model.Absence" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    HttpSession userSession = request.getSession(false);
    if (userSession == null || userSession.getAttribute("userId") == null) {
        response.sendRedirect("login");
        return;
    }

    Professor professor = (Professor) request.getAttribute("professor");
    List<String> classes = (List<String>) request.getAttribute("classes");
    String section = (String) request.getAttribute("section");
    List<Marks> marksList = (List<Marks>) request.getAttribute("marks");
    List<Absence> absencesList = (List<Absence>) request.getAttribute("absences");
    Map<String, String> studentDetailsMap = (Map<String, String>) request.getAttribute("studentDetailsMap");

%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Espace Enseignant</title>
    <link rel="stylesheet" href="css/Enseignant.css">
</head>
<body>
    <div class="container">
        <aside class="sidebar">
            <div class="profile">
                <img src="assets/profile_male.svg" alt="Avatar">
                <p><%= professor.getFirstName() + " " + professor.getLastName() %></p>
            </div>
            <nav>
                <a href="?section=emploi">Emploi</a>
                <a href="?section=notes">Notes</a>
                <a href="?section=absences">Absences</a>
                <a href="logout" class="logout2">Déconnexion</a>
            </nav>
        </aside>

        <main class="content">
            <h1>Sélectionnez une classe</h1>
            <form action="professor" method="GET">
			    <% 
			        String selectedClass = (String) request.getAttribute("selectedClass"); 
			    %>
			    <% if (classes == null || classes.isEmpty()) { %>
			        <p>Vous n'êtes affecté à aucune classe.</p>
			    <% } else { %>
			        <label for="classSelection">Choisir une classe :</label>
			        <select name="classSelection" id="classSelection" onchange="this.form.submit()">
			            <% for (String className : classes) { %>
			                <option value="<%= className %>" <%= className.equals(selectedClass) ? "selected" : "" %>><%= className %></option>
			            <% } %>
			        </select>
			    <% } %>
			</form>



            <% if (section != null && !section.isEmpty()) { %>
                <header>
                    <h1 id="section-title"><%= section %></h1>
                    <hr>
                </header>
                <div id="section-content">
                    <% if ("emploi".equals(section)) { %>
                        <div style="text-align: center; margin-top: 20px;">
                            <img src="assets/emploi.webp" alt="Emploi du temps" class="emploi-image">
                        </div>
                    <% } else if ("notes".equals(section)) { %>
						<% if ("notes".equals(section)) { %>
						    <% if (marksList != null && !marksList.isEmpty()) { %>
						        <div class="notes-container">
						            <table class="notes-table">
						                <thead>
						                    <tr><th>Étudiant (CNE)</th><th>Note</th></tr>
						                </thead>
						                <tbody>
						                    <% for (Marks grade : marksList) { 
						                        String studentDetails = studentDetailsMap != null ? studentDetailsMap.get(grade.getSubject()) : null;
						                    %>
						                        <tr>
						                            <td><%= studentDetails != null ? studentDetails : "Inconnu" %></td>
						                            <td><%= grade.getMark() %></td>
						                        </tr>
						                    <% } %>
						                </tbody>
						            </table>
						        </div>
						    <% } else { %>
						        <p>Aucune note disponible.</p>
						    <% } %>
						<% } %>

                    <% } else if ("absences".equals(section)) { %>
                        <% if (absencesList != null && !absencesList.isEmpty()) { %>
                            <div class="absences-container">
                                <h2>Absences</h2>
                                <table>
                                    <thead>
                                        <tr><th>Date</th><th>Matière</th><th>Justifiée</th></tr>
                                    </thead>
                                    <tbody>
                                        <% for (Absence absence : absencesList) { %>
                                            <tr>
                                                <td><%= absence.getDate() %></td>
                                                <td><%= absence.getSubject() %></td>
                                                <td><%= absence.isJustified() ? "Oui" : "Non" %></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        <% } else { %>
                            <p>Aucune absence enregistrée.</p>
                        <% } %>
                    <% } %>
                </div>
            <% } %>
        </main>
    </div>
</body>
</html>
