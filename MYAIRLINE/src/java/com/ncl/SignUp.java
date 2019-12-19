package com.ncl;



import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;
/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   static int id=0;
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void processEmail(String email){
	
		final String username = "l154359@lhr.nu.edu.pk";
		final String password = "alimuradbodlanaqshbandi123";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

              
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("l154359@lhr.nu.edu.pk"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject("Java Mailer");
			message.setText("Hello this mail is sent from java code");

			Transport.send(message);

			

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		  
		String fname=request.getParameter("FirstName");//will return value  
		
		String lname=request.getParameter("LastName");//will return value  
		
		String email=request.getParameter("EmailAdress");//will return value  
		
		String password=request.getParameter("Password");//will return value 
               
                
               System.out.print("Scripted Code= ------------------------------------------------------"+fname+"============================");       
       
         try{
	         
     
                ESAPI.encoder();
            
//Load driver SQL and other name will be here 
               database db;    
                    db = new database();
              
          
                System.out.println("Ahmad Hassan");
               db.setSignUp(id,email,password,fname,lname);
                id++;
                processEmail(email);
	     
                        
	      
	
	    }catch(Exception ex)
	    {
	 
	    	System.out.println(ex);
	    
	    
	    }
		
		
	

		response.sendRedirect("html/sign_in.html");
		
		
		
		
		
		
		  
	
	}

}
