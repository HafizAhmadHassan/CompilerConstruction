package com.ncl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager_Approved_DB
 */
public class Manager_Approved_DB extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static int id = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager_Approved_DB() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String b1 = request.getParameter("choose1");
        String b2 = request.getParameter("choose2");
        String b3 = request.getParameter("choose3");
        String b4 = request.getParameter("choose4");
        String b5 = request.getParameter("choose5");
        String b6 = request.getParameter("choose6");

        System.out.print(b1 + " " + b2 + " " + b3 + " ");

        PrintWriter out = response.getWriter();

        if (b1.equals("PHP") && b2.equals("PHP") && b3.equals("PHP") && b4.equals("PHP") && b5.equals("PHP") && b6.equals("PHP")) {

            database db = new database();
            try {
                db.updateFlightDetails();
            } catch (SQLException ex) {
                Logger.getLogger(Manager_Approved_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.print("<html>");
            out.print("<body>");

            out.print("<p>Successfully Approved Database Updated</p>");

            out.print("<body>");
            out.print("</html>");

            out.close();

            response.sendRedirect("index.jsp");

        } else {

            response.sendRedirect("html/manager_approval.jsp");

        }

    }

}
