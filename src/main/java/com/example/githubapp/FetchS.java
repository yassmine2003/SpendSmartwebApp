package com.example.demo2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "FetchS", value = "/FetchS")
public class FetchS extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/spendsmart";
        String username = "root";
        String password = "salma";

        // SQL query to fetch data from the table
        String sql = "SELECT * FROM utilisateur where userID=1";

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Modify Your Profile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Modify Your Profile Here:</h1>");
            out.println("<form method=\"post\" action>");
            out.println("<div class=\"search_bar\">");

            // Populate input fields with fetched data
            if (resultSet.next()) {
                out.println("<label>First Name:</label>");
                out.println("<input type=\"search\" name=\"first_name\" placeholder=\"First Name\" value=\"" + resultSet.getString("first_name") + "\"> <br>");
                out.println("<label>Last Name:</label>");
                out.println("<input type=\"search\" name=\"last_name\" placeholder=\"Last Name\" value=\"" + resultSet.getString("last_name") + "\"> <br>");
                out.println("<label>Username:</label>");
                out.println("<input type=\"search\" name=\"username\" placeholder=\"Username\" value=\"" + resultSet.getString("username") + "\"> <br>");
                out.println("<label>Current Password:</label>");
                out.println("<input type=\"password\" name=\"current_password\" placeholder=\"Current Password\"> <br>");
                out.println("<label>New Password:</label>");
                out.println("<input type=\"password\" name=\"new_password\" placeholder=\"New Password\"> <br>");
                out.println("<label>Confirm Password:</label>");
                out.println("<input type=\"password\" name=\"confirm_password\" placeholder=\"Confirm Password\"> <br>");
            }

            out.println("<button type=\"submit\">Submit</button>");
            out.println("</div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
