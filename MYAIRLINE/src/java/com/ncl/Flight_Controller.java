/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HafizAhmad
 */
public class Flight_Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        database db = new database();
        try {
            Flight_Details_Info fdi = db.verifyBookingInfo(request.getParameter("from"), request.getParameter("to"), request.getParameter("ddate"), request.getParameter("rdate"));
            if (fdi == null ) {

                response.sendRedirect("html/error.html");
            } else 
            {
                   request.setAttribute("FD", fdi);
                   
          //          System.out.print("Ye dekho\n = " +fdi.From +fdi.To+fdi.DDATE+fdi.RTime+ "\n Price "+fdi.EPrice);
//                   
//                   request.setAttribute("to", fdi.To);
//                   
//                   request.setAttribute("seats", fdi.Seats);
//                   
//                   request.setAttribute("ddate", fdi.DDATE);
//                   
//                   request.setAttribute("rdate", fdi.RDATE);
//                   
//                   request.setAttribute("dtime", fdi.DTime);
//                   
//                   request.setAttribute("rtime", fdi.RTime);
//                   
//                   request.setAttribute("e", fdi.EPrice);
//                   
//                System.out.print("Ye dekho\n = " +fdi.EPrice);
                   
                request.getRequestDispatcher("html/flight_t.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            response.sendRedirect("html/error.html");
            Logger.getLogger(Flight_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
