package com.ncl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;


/**
 * Servlet implementation class Log_In
 */
public class Log_In extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log_In() {
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
		// TODO Auto-generated method stub
		String email=request.getParameter("L_EmailAdress");//will return value  
		
		String password=request.getParameter("L_Password");//will return value  

			System.out.println("Here-----------");
			
		ESAPI.encoder();
		try{
		   //Load driver SQL and other name will be here 
			
			database db=new database();
                       Sign_Up_Info si= db.getSignUp(email, password);
			HttpSession session2=request.getSession(true);  
			String s=(String)session2.getAttribute("email");
			System.out.print(s);
			
			    if (si != null){
			    	HttpSession session=request.getSession(false);  
			        session.setAttribute("email",email);  
                                request.getRequestDispatcher("index.jsp").forward(request, response);  
			          
		
			    
			    }
                            else{
			    	
				    response.sendRedirect("html/sign_in.html");
				}
	 System.out.println("Matches");
	    	  
	    }
		catch(Exception ex)
	    {
	    	PrintWriter pw= response.getWriter();
	    	pw.print("404");
	    	 

	    	System.out.println(ex);
	    
	    
	    }

		
		
		
		
		

	
	
	
	}

}
