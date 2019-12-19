package com.ncl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Booking_Controller
 */
public class Booking_Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static int id = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String fid = request.getParameter("FID");
        int price = 0;
        String classs = request.getParameter("clas");
        int fd = Integer.parseInt(fid);
        try {
            //Load driver SQL and other name will be here 

            HttpSession session2 = request.getSession(false);
            String emails = (String) session2.getAttribute("email");
            if (session2 == null || emails == null) {
                response.sendRedirect("html/error.html");

            }

            database db = new database();
            Flight_Details_Info myflight = db.getFlightDetails();
            if (classs.equals("E")) {
                db.setBook_Flight(id, fd, emails, myflight.EPrice, classs);
            } else {

                if (classs.equals("F")) {
                    db.setBook_Flight(id, fd, emails, myflight.FPrice, classs);
                } else {

                    if (classs.equals("B")) {
                        db.setBook_Flight(id, fd, emails, myflight.BPrice, classs);
                    }

                }

            }

            //Update Flight
            db.updateFlight_Details_Seats((myflight.Seats) - 1);

                
            request.getRequestDispatcher("html/payment.jsp").forward(request, response);
           
        } catch (Exception ex) {
                response.sendRedirect("html/error.html");
            System.out.println(ex);

        }

    }

}
