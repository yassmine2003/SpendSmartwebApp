package com.example.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "HomeS", value = "/HomeS")
public class AddS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expenseName = request.getParameter("expense");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String date = request.getParameter("date");

        Connection con = null;
        PreparedStatement pst = null;

        try {
            String url = "jdbc:mysql://localhost:3306/spendsmart";
            String username = "root";
            String password = "salma";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement("INSERT INTO depense (montant,date, description, typeExpense) VALUES (?, ?, ?, ?)");
            pst.setString(1, expenseName);
            pst.setString(2,date );
            pst.setString(3, description);
            pst.setString(4, type);

            int rowCount = pst.executeUpdate();

            if (rowCount > 0) {
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
