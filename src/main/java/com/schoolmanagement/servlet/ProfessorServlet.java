package com.schoolmanagement.servlet;

import com.schoolmanagement.dao.ProfessorDAO;
import com.schoolmanagement.dao.AbsenceDAO;
import com.schoolmanagement.dao.MarksDAO;
import com.schoolmanagement.dao.UserDAO;
import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.dao.ClassDAO;
import com.schoolmanagement.dao.TimetableDAO;
import com.schoolmanagement.model.Professor;
import com.schoolmanagement.model.User;
import com.schoolmanagement.model.StudentMarks;
import com.schoolmanagement.model.Marks;
import com.schoolmanagement.model.Class;
import com.schoolmanagement.model.Absence;
import com.schoolmanagement.model.Timetable;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
    private UserDAO userDAO;
    private ProfessorDAO professorDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        professorDAO = new ProfessorDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        MarksDAO marksDAO = new MarksDAO();
        StudentDAO stDAO = new StudentDAO();

        String studentCne = request.getParameter("studentcne");
        String classIdStr = request.getParameter("classId");
        String markStr = request.getParameter("mark");
        String classSelection = request.getParameter("classSelection"); // Retrieve class selection
        String section = request.getParameter("section"); // Retrieve section

        if (classIdStr == null || classIdStr.isEmpty() || markStr == null || markStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing classId or mark");
            return;
        }

        try {
            int studentId = stDAO.getStudentByUserCne(studentCne).getUserId();
            int classId = Integer.parseInt(classIdStr);
            double markValue = Double.parseDouble(markStr);

            Marks mark = new Marks(studentId, classId, markValue);
            marksDAO.addMark(mark);

            // Redirect to the same section and class
            response.sendRedirect("professor?section=" + section + "&classSelection=" + classSelection);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers: " + e.getMessage());
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");
        ClassDAO classDAO = new ClassDAO();
        TimetableDAO timetableDAO = new TimetableDAO();

        String selectedClass = request.getParameter("classSelection");
        String section = request.getParameter("section");
        if (section == null) section = "emploi";  // Default section is emploi

        Professor professor = professorDAO.getProfessorByUserId(userId);
        List<Class> full_classes = classDAO.getClassesByProfessorId(userId);
        List<String> classes = new ArrayList<>();
        if ("emploi".equals(section)) {
            List<Timetable> timetable = timetableDAO.getTimetableForProfessor();  // Fetch timetable for the professor
            request.setAttribute("timetable", timetable);
            request.setAttribute("sectionTitle", "Emploi du Temps");
        }
        if ("absences".equals(section)) {
            request.setAttribute("sectionTitle", "Absences");
        }
        if ("notes".equals(section)) {
            request.setAttribute("sectionTitle", "Notes");
        }
        
        
        int classId = -1;
        for (Class c : full_classes) {
            classes.add(c.getName());
        }

        if ((selectedClass == null || selectedClass.isEmpty()) && !classes.isEmpty()) {
            selectedClass = classes.get(0);  // Default to the first class if not selected
        }

        for (Class c : full_classes) {
            if (c.getName().equals(selectedClass)) {
                classId = c.getId();
                break;
            }
        }

        List<Marks> marksList = null;
        List<StudentMarks> studentMarksList = new ArrayList<>();
        List<Absence> absencesList = null;
        
        
        

        if (selectedClass != null && classId != -1) {
            if ("notes".equals(section)) {
                marksList = classDAO.getMarksByClassId(classId);

                // Populate the studentMarksList with both Marks and student names
                for (Marks grade : marksList) {
                    String studentName = classDAO.getStudentNameById(grade.getStudentId()); // Fetch student name based on studentId
                    StudentMarks studentMarks = new StudentMarks(grade, studentName);
                    studentMarksList.add(studentMarks);
                }
            } else if ("absences".equals(section)) {
                absencesList = AbsenceDAO.getAbsencesByClassId(classId);
            }
        }

        // Set the studentMarksList as an attribute to be used in the JSP
        request.setAttribute("studentMarksList", studentMarksList);
        request.setAttribute("absences", absencesList);
        request.setAttribute("classId", classId);
        request.setAttribute("professor", professor);
        request.setAttribute("classes", classes);
        request.setAttribute("section", section);
        request.setAttribute("marks", marksList);
        request.setAttribute("selectedClass", selectedClass);
        request.getRequestDispatcher("views/Enseignant.jsp").forward(request, response);
    }
}
