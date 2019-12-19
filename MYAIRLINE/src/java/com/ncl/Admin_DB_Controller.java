package com.ncl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_DB_Controller
 */
public class Admin_DB_Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static int id = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DB_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        System.out.println("\n    -----------  IN DB CONTROLLER   ------------ \n");

        String Fist_Class = request.getParameter("First_Class");//will return value  
        int F = Integer.parseInt(Fist_Class);
        String Bussiness_Class = request.getParameter("Bussiness_Class");//will return value  
        int B = Integer.parseInt(Bussiness_Class);

        String Economy_Class = request.getParameter("Economy_Class");//will return value  
        int E = Integer.parseInt(Economy_Class);
        String f2 = request.getParameter("F2");//will return value  
        String f1 = request.getParameter("F1");//will return value  
        String f3 = request.getParameter("F3");//will return value  

        
        
        String From = request.getParameter("From");//will return value  
        String To = request.getParameter("To");//will return value  
        String Seats = request.getParameter("Seats");//will return value  
        int seats=Integer.parseInt(Seats);
        
        String Arrival_Time = request.getParameter("Arrival_Time");//will return value  
        String Departure_Time = request.getParameter("Departure_Time");//will return value  
    
 String Arrival_Date = request.getParameter("Arrival_Date");//will return value  
 
  String Departure_Date = request.getParameter("Departure_Date");//will return value  
    

 
  
        try {
            //Load driver SQL and other name will be here 

            database db=new database();

          
         boolean p;
            p = db.setFlightDetails(id,F,f1,E,f2,B,f3,From,To,seats,Arrival_Time,Departure_Time, Departure_Date,Arrival_Date);
          
            if(p)
            id++;
        
                response.sendRedirect("index.jsp");

   

        } catch (Exception ex) {
            System.out.print(ex);
            response.sendRedirect("html/admin_page.jsp");
        }

    }

}
