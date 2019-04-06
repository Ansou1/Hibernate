package com.ansou.testDB;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class testDB extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String user = "springstudent";
        String password = "springstudent";
        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSl=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connection to database: " + jdbcURL);

            Connection conn = DriverManager.getConnection(jdbcURL, user, password);

            out.println("Connexion successful");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
