package com.schoolmanagement.servlet;

import java.io.IOException;
import java.util.List;

import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentDAO.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
}