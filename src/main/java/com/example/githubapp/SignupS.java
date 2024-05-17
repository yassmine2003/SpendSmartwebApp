package com.example.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "SignupS", value = "/SignupS")
public class SignupS extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("first_name");
        String lastName=request.getParameter("last_name");
        String username1=request.getParameter("username");
        String uemail=request.getParameter("email");
        String upswd=request.getParameter("pass");
        RequestDispatcher dispatcher=null;
        Connection con=null;

        try {
            String url ="jdbc:mysql://localhost:3306/spendsmart";
            String username = "root";
            String password = "salma";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            PreparedStatement pst = con.prepareStatement("insert into utilisateur(prenom,nom,username,email,password) values(?,?,?,?,?)");
            pst.setString(1, uname);
            pst.setString(2, lastName);
            pst.setString(3, username1);
            pst.setString(4, uemail);
            pst.setString(5, upswd);

            try {
            int rowCount = pst.executeUpdate();
            request.getRequestDispatcher("home.jsp").forward(request,response);

            if(rowCount>0) {
                request.setAttribute("status", "success");
            }
            else {
                request.setAttribute("status", "success"); //switch success with failed
            }
            dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Username already exists. Please choose a different username.");
                dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
