package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginS", value = "/LoginS")
public class LoginS extends HttpServlet {
    private static UserDao userDao;
//    @Override
//    public void init() throws ServletException {
//        userDao = new UserDao();
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            if (userDao.isValidUser(username, password)) {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<h1>Log In Failed</h1>");
                out.println("<a href='index.jsp'> Try Again!</a>");
            }
        } catch (SQLException e) {
            throw new ServletException("Error in login process", e);
        }
    }
}
