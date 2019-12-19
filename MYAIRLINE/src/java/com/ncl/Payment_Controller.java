package com.ncl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Payment_Controller
 */
public class Payment_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static int id=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		

	    
	    
	    
String sd=request.getParameter("streetaddress");//will return value  
		
		String c=request.getParameter("city");//will return value  
		
		String z=request.getParameter("zipcode");//will return value  
		
		String e=request.getParameter("email");//will return value  
		
		

String fname=request.getParameter("first-name");//will return value  
		
		String lname=request.getParameter("last-name");//will return value  
		
		String n=request.getParameter("number");//will return value  
		
		String ex=request.getParameter("expiry");//will return value  
		String cvc=request.getParameter("cvc");//will return value  
		

		try{
	        //Load driver SQL and other name will be here 
	      
			
			
			 HttpSession session2=request.getSession(true);  
		       String emails = (String)session2.getAttribute("email");  
		      if(emails==null){

		          response.sendError(0, "404");
		      		    	  	    	  
		    	  
		      }

	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  System.out.println("inside SignUp");
	        //define Connection URL
	        String url="jdbc:odbc:FlightSystemDSN";
	        
	        //not having user name password
	        
	        Connection con=DriverManager.getConnection(url,"","");
	        
	        Statement st=con.createStatement();
	        

	        System.out.println("inside SignUp2");
	                
	       String sql3= "insert into Payment values('"+id+"',+'"+sd+"','"+c+"','"+z+"','"+e+"','"+lname+"','"+n+"','"+ex+"','"+cvc+"')";
	       id++; 
	       st.executeUpdate(sql3);

	         
	        
	       response.sendRedirect("html/invoice.html");
	
	       
	       

	     con.close();
	                
	    }
		catch(Exception ex1){
	    
	    	System.out.println(ex1);

		       response.sendRedirect("html/invoice.html");
				    
	    
	    }

	}

}
