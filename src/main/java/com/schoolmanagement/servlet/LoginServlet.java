package com.schoolmanagement.servlet;

import com.schoolmanagement.dao.UserDAO;
import com.schoolmanagement.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get email and password from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        System.out.println(password);
        // Authenticate the user
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(email);
        System.out.println(user);
        System.out.println(user.getPassword());
        if (user != null && user.getPassword().equals(password)) {
            // Login successful
            HttpSession session = request.getSession();
            
            session.setAttribute("user", user); // Store user object in session
            session.setAttribute("userId", user.getId());
            // Redirect based on user role
            switch (user.getRole()) {
                case "admin":
                    response.sendRedirect("adminDashboard.jsp");
                    break;
                case "professor":
                    response.sendRedirect("professor");
                    break;
                case "student":
                	System.out.println("going student");
                    response.sendRedirect("student");
                    break;
                default:
                    response.sendRedirect("dashboard.jsp");
            }
        } else {
            // Login failed
            response.sendRedirect("login.jsp?error=1");
        }
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.getRequestDispatcher("/views/sign-in.jsp").forward(request, response);
    	
    	
    }
}