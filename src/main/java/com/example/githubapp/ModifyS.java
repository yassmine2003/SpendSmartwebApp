package com.example.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "ModifyS", value = "/ModifyS")
public class ModifyS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expense = request.getParameter("expense");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String date = request.getParameter("date");

        // SQL query to insert data into the table
        String sql = "UPDATE depense SET montant = ?,date = ?,description = ?,typeExpense = ?;";

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spendsmart", "root", "salma");
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1,expense);
            statement.setString(2,date);
            statement.setString(3,description);
            statement.setString(4,type);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Expense added successfully!");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add expense.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        }
    }
}
