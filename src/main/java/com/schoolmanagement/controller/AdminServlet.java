package com.schoolmanagement.controller;

import com.schoolmanagement.dao.*;
import com.schoolmanagement.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin-dashboard")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "viewProfessors";  // Default action
        }

        // Set the action for display on JSP
        request.setAttribute("action", action);
        ProfessorDAO professorDAO = new ProfessorDAO();
        AbsenceDAO absenceDAO = new AbsenceDAO();
        MarksDAO marksDAO = new MarksDAO();
        TimetableDAO timetableDAO = new TimetableDAO();
        StudentDAO studentDAO = new StudentDAO();

        // Perform actions based on the request
        switch (action) {
            case "viewProfessors":
                List<Professor> professors = professorDAO.getAllProfessors();
                request.setAttribute("professors", professors);
                break;

            case "addProfessor":
                request.getRequestDispatcher("/addProfessor.jsp").forward(request, response);
                return;

            case "editProfessor":
                int professorId = Integer.parseInt(request.getParameter("id"));
                Professor professor = professorDAO.getProfessorByUserId(professorId);
                request.setAttribute("professor", professor);
                request.getRequestDispatcher("/editProfessor.jsp").forward(request, response);
                return;

            case "deleteProfessor":
                professorId = Integer.parseInt(request.getParameter("id"));
                professorDAO.deleteProfessor(professorId);
                response.sendRedirect("admin-dashboard?action=viewProfessors");
                return;

            case "viewStudents":
                List<Student> students = studentDAO.getAllStudents();
                request.setAttribute("students", students);
                break;

            case "addStudent":
                request.getRequestDispatcher("/addStudent.jsp").forward(request, response);
                return;

            case "editStudent":
                int studentId = Integer.parseInt(request.getParameter("id"));
                Student student = studentDAO.getStudentByUserId(studentId);
                request.setAttribute("student", student);
                request.getRequestDispatcher("/editStudent.jsp").forward(request, response);
                return;

            case "deleteStudent":
                studentId = Integer.parseInt(request.getParameter("id"));
                studentDAO.deleteStudent(studentId);
                response.sendRedirect("admin-dashboard?action=viewStudents");
                return;

            case "viewAbsences":
                List<Absence> absences = absenceDAO.getAllAbsences(); // Example, would use current student ID
                request.setAttribute("absences", absences);
                break;

            case "addAbsence":
                request.getRequestDispatcher("/addAbsence.jsp").forward(request, response);
                return;

            case "editAbsence":
                int absenceId = Integer.parseInt(request.getParameter("id"));
                Absence absence = absenceDAO.getAbsencesByStudentId(absenceId).get(0); // Assuming first result
                request.setAttribute("absence", absence);
                request.getRequestDispatcher("/editAbsence.jsp").forward(request, response);
                return;

            case "deleteAbsence":
                absenceId = Integer.parseInt(request.getParameter("id"));
                absenceDAO.deleteAbsence(absenceId);
                response.sendRedirect("admin-dashboard?action=viewAbsences");
                return;

            case "viewMarks":
                List<Marks> marks = marksDAO.getAllMarks(); 
                request.setAttribute("marks", marks);
                break;

            case "addMark":
                request.getRequestDispatcher("/addMark.jsp").forward(request, response);
                return;

            case "editMark":
                int markId = Integer.parseInt(request.getParameter("id"));
                Marks mark = marksDAO.getMarksByStudentId(markId).get(0); // Assuming first result
                request.setAttribute("mark", mark);
                request.getRequestDispatcher("/editMark.jsp").forward(request, response);
                return;

            case "deleteMark":
                markId = Integer.parseInt(request.getParameter("id"));
                marksDAO.deleteMark(markId, 1); // Example, would use current student ID
                response.sendRedirect("admin-dashboard?action=viewMarks");
                return;

            case "viewTimetable":
                List<Timetable> timetable = timetableDAO.getTimetableForStudent(1); // Example, would use current student ID
                request.setAttribute("timetable", timetable);
                break;

            case "addTimetable":
                request.getRequestDispatcher("/addTimetable.jsp").forward(request, response);
                return;

            case "editTimetable":
                int timetableId = Integer.parseInt(request.getParameter("id"));
                Timetable timetableSlot = timetableDAO.getTimetableForStudent(timetableId).get(0); // Assuming first result
                request.setAttribute("timetable", timetableSlot);
                request.getRequestDispatcher("/editTimetable.jsp").forward(request, response);
                return;


            default:
                break;
        }

        // Forward to the JSP page
        request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "addProfessor":
                ProfessorDAO professorDAO = new ProfessorDAO();
                Professor professor = new Professor();
                professor.setUserId(Integer.parseInt(request.getParameter("userId")));
                professor.setFirstName(request.getParameter("firstName"));
                professor.setLastName(request.getParameter("lastName"));
                professor.setCni(request.getParameter("cni"));
                professor.setEmploymentDate(new java.util.Date(request.getParameter("employmentDate")));
                professor.setSalary(Double.parseDouble(request.getParameter("salary")));
                professorDAO.addProfessor(professor);
                response.sendRedirect("admin-dashboard?action=viewProfessors");
                break;

            case "editProfessor":
                professorDAO = new ProfessorDAO();
                professor = new Professor();
                professor.setUserId(Integer.parseInt(request.getParameter("userId")));
                professor.setFirstName(request.getParameter("firstName"));
                professor.setLastName(request.getParameter("lastName"));
                professor.setCni(request.getParameter("cni"));
                professor.setEmploymentDate(new java.util.Date(request.getParameter("employmentDate")));
                professor.setSalary(Double.parseDouble(request.getParameter("salary")));
                professorDAO.updateProfessor(professor);
                response.sendRedirect("admin-dashboard?action=viewProfessors");
                break;

            case "addStudent":
                StudentDAO studentDAO = new StudentDAO();
                Student student = new Student();
                student.setUserId(Integer.parseInt(request.getParameter("userId")));
                student.setFirstName(request.getParameter("firstName"));
                student.setLastName(request.getParameter("lastName"));
                student.setCne(request.getParameter("cne"));
                student.setStudyLevel(request.getParameter("studyLevel"));
                student.setStatus(request.getParameter("status"));
                student.setBirthday(new java.util.Date(request.getParameter("birthday")));
                studentDAO.addStudent(student);
                response.sendRedirect("admin-dashboard?action=viewStudents");
                break;

            case "editStudent":
                studentDAO = new StudentDAO();
                student = new Student();
                student.setUserId(Integer.parseInt(request.getParameter("userId")));
                student.setFirstName(request.getParameter("firstName"));
                student.setLastName(request.getParameter("lastName"));
                student.setCne(request.getParameter("cne"));
                student.setStudyLevel(request.getParameter("studyLevel"));
                student.setStatus(request.getParameter("status"));
                student.setBirthday(new java.util.Date(request.getParameter("birthday")));
                studentDAO.updateStudent(student);
                response.sendRedirect("admin-dashboard?action=viewStudents");
                break;

            case "addAbsence":
                AbsenceDAO absenceDAO = new AbsenceDAO();
                Absence absence = new Absence();
                absence.setStudentId(Integer.parseInt(request.getParameter("studentId")));
                absence.setClassId(Integer.parseInt(request.getParameter("classId")));
                absence.setDate(new java.util.Date(request.getParameter("date")));
                absence.setJustified(Boolean.parseBoolean(request.getParameter("justified")));
                absenceDAO.addAbsence(absence);
                response.sendRedirect("admin-dashboard?action=viewAbsences");
                break;

            case "editAbsence":
                absenceDAO = new AbsenceDAO();
                absence = new Absence();
                absence.setId(Integer.parseInt(request.getParameter("id")));
                absence.setStudentId(Integer.parseInt(request.getParameter("studentId")));
                absence.setClassId(Integer.parseInt(request.getParameter("classId")));
                absence.setDate(new java.util.Date(request.getParameter("date")));
                absence.setJustified(Boolean.parseBoolean(request.getParameter("justified")));
                absenceDAO.updateAbsence(absence);
                response.sendRedirect("admin-dashboard?action=viewAbsences");
                break;

            case "addMark":
                MarksDAO marksDAO = new MarksDAO();
                Marks mark = new Marks();
                mark.setStudentId(Integer.parseInt(request.getParameter("studentId")));
                mark.setClassId(Integer.parseInt(request.getParameter("classId")));
                mark.setMark(Double.parseDouble(request.getParameter("mark")));
                marksDAO.addMark(mark);
                response.sendRedirect("admin-dashboard?action=viewMarks");
                break;

            case "editMark":
                marksDAO = new MarksDAO();
                mark = new Marks();
                mark.setStudentId(Integer.parseInt(request.getParameter("studentId")));
                mark.setClassId(Integer.parseInt(request.getParameter("classId")));
                mark.setMark(Double.parseDouble(request.getParameter("mark")));
                marksDAO.updateMark(mark);
                response.sendRedirect("admin-dashboard?action=viewMarks");
                break;

            case "addTimetable":
                TimetableDAO timetableDAO = new TimetableDAO();
                Timetable timetable = new Timetable();
                timetable.setTimeSlot(request.getParameter("timeSlot"));
                timetable.setMonday(request.getParameter("monday"));
                timetable.setTuesday(request.getParameter("tuesday"));
                timetable.setWednesday(request.getParameter("wednesday"));
                timetable.setThursday(request.getParameter("thursday"));
                timetable.setFriday(request.getParameter("friday"));
                timetableDAO.addTimetable(timetable);
                response.sendRedirect("admin-dashboard?action=viewTimetable");
                break;

            case "editTimetable":
                timetableDAO = new TimetableDAO();
                timetable = new Timetable();
                timetable.setTimeSlot(request.getParameter("timeSlot"));
                timetable.setMonday(request.getParameter("monday"));
                timetable.setTuesday(request.getParameter("tuesday"));
                timetable.setWednesday(request.getParameter("wednesday"));
                timetable.setThursday(request.getParameter("thursday"));
                timetable.setFriday(request.getParameter("friday"));
                timetableDAO.updateTimetable(timetable);
                response.sendRedirect("admin-dashboard?action=viewTimetable");
                break;

            case "deleteTimetable":
                timetableDAO = new TimetableDAO();
                String timeSlot = request.getParameter("timeSlot");
                timetableDAO.deleteTimetable(timeSlot);
                response.sendRedirect("admin-dashboard?action=viewTimetable");
                break;
            default:
                break;
        }
    }
}