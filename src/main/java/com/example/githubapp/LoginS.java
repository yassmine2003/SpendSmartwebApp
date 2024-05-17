package com.example.demo2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "LoginS", value = "/login")
public class LoginS extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uemail = request.getParameter("username");
        String upswd = request.getParameter("password");
        Connection con = null;
        HttpSession session = request.getSession();

        try {
            String url = "jdbc:mysql://localhost:3306/spendsmart";
            String username = "root";
            String password = "salma";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try{con = DriverManager.getConnection(url,username,password);}catch(Exception e){ System.out.println("didnt connect");}

            PreparedStatement pst = con.prepareStatement("select * from utilisateur where username=? and password=?");
            pst.setString(1, uemail);
            pst.setString(2, upswd);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                session.setAttribute("name", rs.getString("uname"));
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                request.setAttribute("error", "Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while processing your request.");
            request.getRequestDispatcher("home.jsp").forward(request, response);//change it to the index.jsp before submiting to github
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}