package com.schoolmanagement.servlet;

import java.io.IOException;
import java.util.List;

import com.schoolmanagement.dao.MarksDAO;
import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.dao.AbsenceDAO;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.model.Marks;
import com.schoolmanagement.model.Absence;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO;
    private MarksDAO marksDAO;
    private AbsenceDAO absenceDAO;

    public void init() {
        studentDAO = new StudentDAO();
        marksDAO = new MarksDAO();
        absenceDAO = new AbsenceDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("login");
            return;
        }

        // Fetch student information
        Student student = studentDAO.getStudentByUserId(userId);
        if (student == null) {
            response.sendRedirect("login");
            return;
        }

        // Set student information in request
        request.setAttribute("student", student);

        // Determine the section to display
        String section = request.getParameter("section");
        if (section == null) {
            section = "emploi"; // Default section
        }
        request.setAttribute("section", section);

        // Fetch data based on the section
        switch (section) {
            case "notes":
                List<Marks> grades = marksDAO.getMarksByStudentId(student.getUserId());
                request.setAttribute("grades", grades);
                request.setAttribute("sectionTitle", "Notes");
                break;
            case "absences":
                List<Absence> absences = absenceDAO.getAbsencesByStudentId(student.getUserId());
                request.setAttribute("absences", absences);
                request.setAttribute("sectionTitle", "Absences");
                break;
            default:
                request.setAttribute("sectionTitle", "Emploi du Temps");
                break;
        }

        // Forward to the JSP
        request.getRequestDispatcher("views/Etudiant.jsp").forward(request, response);
    }
}