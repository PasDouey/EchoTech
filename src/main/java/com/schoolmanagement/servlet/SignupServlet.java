package com.schoolmanagement.servlet;

import com.schoolmanagement.dao.UserDAO;
import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.model.User;
import com.schoolmanagement.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private UserDAO userDAO;
    private StudentDAO studentDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cne = request.getParameter("cne");
        String studyLevel = request.getParameter("studyLevel");
        String birthdayStr = request.getParameter("birthday"); // Assuming the date is in "yyyy-MM-dd" format

        // Convert birthday to java.sql.Date
        Date birthday = Date.valueOf(birthdayStr);

        // Create a new User object
        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // In a real application, hash the password before saving
        user.setRole("student"); // Default role for students

        // Insert the User into the database
        userDAO.addUser(user);

        // Retrieve the newly created user's ID
        User createdUser = userDAO.getUserByEmail(email);
        if (createdUser == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to create user.");
            return;
        }

        // Create a new Student object
        Student student = new Student();
        student.setUserId(createdUser.getId());
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setCne(cne);
        student.setStudyLevel(studyLevel);
        student.setStatus("active"); // Default status
        student.setBirthday(birthday);

        // Insert the Student into the database
        studentDAO.addStudent(student);

        // Redirect to a success page or login page
        response.sendRedirect("login.jsp");
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
    
    	
    }


}
