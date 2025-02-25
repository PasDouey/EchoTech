package com.schoolmanagement.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.schoolmanagement.dao.MarksDAO;
import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.dao.AbsenceDAO;
import com.schoolmanagement.dao.TimetableDAO;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.model.Marks;
import com.schoolmanagement.model.Absence;
import com.schoolmanagement.model.Timetable;

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
    private TimetableDAO timetableDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
        marksDAO = new MarksDAO();
        absenceDAO = new AbsenceDAO();
        timetableDAO = new TimetableDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) Optional.ofNullable(session).map(s -> s.getAttribute("userId")).orElse(null);

        if (userId == null) {
            response.sendRedirect("login");
            return;
        }

        Student student = studentDAO.getStudentByUserId(userId);
        if (student == null) {
            response.sendRedirect("login");
            return;
        }

        request.setAttribute("student", student);
        String section = Optional.ofNullable(request.getParameter("section")).orElse("emploi");
        request.setAttribute("section", section);

        switch (section) {
            case "notes":
                request.setAttribute("grades", marksDAO.getMarksByStudentId(student.getUserId()));
                request.setAttribute("sectionTitle", "Notes");
                break;
            case "absences":
                request.setAttribute("absences", absenceDAO.getAbsencesByStudentId(student.getUserId()));
                request.setAttribute("sectionTitle", "Absences");
                break;
            case "emploi":
            default:
                List<Timetable> timetable = timetableDAO.getTimetableForStudent(student.getUserId());
                request.setAttribute("timetable", timetable);
                request.setAttribute("sectionTitle", "Emploi du Temps");
                break;
        }

        request.getRequestDispatcher("views/Etudiant.jsp").forward(request, response);
    }
}