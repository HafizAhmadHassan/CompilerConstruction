package com.ncl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Flight_Table_Controller
 */
public class Flight_Table_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flight_Table_Controller() {
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

	
	
	
		String from=request.getParameter("from");//will return value  
		
		

		
		try{
		   //Load driver SQL and other name will be here 
			
			
			
			Flight_Table_DAO flightDAO = new Flight_Table_DAO();
			Flight_Table_Info  ft= flightDAO.searchPerson(from);
	       
			    if (ft != null){
			    
			    	  ArrayList<String> list=new ArrayList<String>();
			    	  	list.add(ft.getSeats());  
				    	list.add(ft.getPrice());
				    	list.add(ft.getRtime());
				    	list.add(ft.getDtime());
					    	
		
				    	
				    	
				    	
				    	//	    	  request.setAttribute("List", list);
			    	
			    	
			    	
	//		    	ServletContext sc=getServletContext();
//			    	RequestDispatcher rd=sc.getRequestDispatcher("/html/book_flight_table.jsp");
			    	

	//		    	 System.out.print("Ssdopaaaaid");
		//	    	rd.forward(request, response);
		
			    
			    }else{
			    	
				    response.sendError(404);
						    	
			    	
			    }
				
			
	    //   preparedStatement.setString(1, email);
	       
	       
//	      ResultSet rs=st.executeQuery(sql);
	       

	       
	    
	    	 
	        
	        

	    }
		
		
		
		catch(Exception ex)
	    {
	    	PrintWriter pw= response.getWriter();
	    	pw.print("404");
	    	 

	    	System.out.println(ex);
	    
	    
	    }

		
		
		
		
		

	
	
	}

}
