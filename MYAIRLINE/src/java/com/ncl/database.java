package com.ncl;

import java.util.Date;

import static com.ncl.Admin_DB_Controller.id;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HafizAhmad
 */
public class database {
    

  public   Connection conn ;
 public Statement st;
public String sql;
public ResultSet rs; 
public PreparedStatement pst;
    
   public  database(){
    
    
    
    st=null;
    rs=null;
    pst=null;
    conn = null; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Flight_Management";
            String user = "TestingUser";
            String pass = "4546";
            conn = DriverManager.getConnection(dbURL,user,pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
               
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        

  
    
    }


public void setSignUp(int id,String email,String password,String fname,String lname) throws SQLException{
if(conn.isClosed())
     System.out.println("Ahmad ------------------------ Hassan");
            
	     st=conn.createStatement();
             System.out.print("3");
                String sql3= "insert into Sign_Up values('"+id+"',?,?,?,?)";
                
              //  String sql3= "insert into Sign_Up values('"+id+"',+'"+email+"','"+password+"','"+fname+"','"+lname+"')";
                
                	id++;
                	
                PreparedStatement pStmt = conn.prepareStatement(sql3);
		
                pStmt.setString(1,email);
                
                pStmt.setString(2,password);
                
                pStmt.setString(3,fname);
                
                pStmt.setString(4,lname);
           
                ResultSet rs = pStmt.executeQuery();
	   
}

public Sign_Up_Info getSignUp(String email,String password) throws SQLException{
			Sign_Up_Info si=null;
                String sql = "SELECT * FROM Sign_Up WHERE Email = ? AND Password = ?";
		
                PreparedStatement pStmt = conn.prepareStatement(sql);
		
                pStmt.setString(1,email);
                
                pStmt.setString(2,password);
	
	
                ResultSet rs = pStmt.executeQuery();
	if (rs.next() ) {
			
			String email2 = rs.getString("Email");
			String password2 = rs.getString("Password");
			String fname = rs.getString("First_Name");
			String lname = rs.getString("Last_Name");
			
			 si = new Sign_Up_Info(fname,lname,email,password);
	
			}
        return si;
		
}
public boolean setFlightDetails(int id, int FPrice,String FFeature,int EPrice,String EFeature,int BPrice,String BFeature,String From,String To,int Seats,String DTime,String RTime,String DDATE,String RDATE) throws SQLException{
    
             st=conn.createStatement();
             String sql3= "insert into Flight_Details values('"+id+"',?,?,?,?,?,?,?,?,?,?,?,0,?,?)";
            
                PreparedStatement pStmt = conn.prepareStatement(sql3);
		
                pStmt.setInt(1,FPrice);
                
                pStmt.setString(2,FFeature);
                
                pStmt.setInt(3,EPrice);
                
                pStmt.setString(4,EFeature);
                pStmt.setInt(5, BPrice);
                pStmt.setString(6,BFeature);
                pStmt.setString(7,From);
                pStmt.setString(8,To);
                pStmt.setInt(9,Seats);
                pStmt.setString(10,DTime);
              
                pStmt.setString(11,RTime);
               pStmt.setString(12,DDATE);
               pStmt.setString(13,RDATE);
               
           
                ResultSet rs = pStmt.executeQuery();
             
             
            
    return true;
}
public void updateFlightDetails() throws SQLException{

sql ="Update Flight_Details SET Approved=1";
pst = conn.prepareStatement(sql);
pst.executeQuery();

}
public  Flight_Details_Info getFlightDetails() throws SQLException{

    Flight_Details_Info fdi=null;
 
     String sql = "SELECT * FROM Flight_Details";
     
     
     
     
     PreparedStatement pStmt = conn.prepareStatement(sql);
		
     
	
                ResultSet rs = pStmt.executeQuery();
	if (rs.next() ) {
			
			int FID = rs.getInt("Flight_Id");
			int fprice = rs.getInt("FPrice");
			  String ffeatures = rs.getString("FFeatures");
			
			int eprice = rs.getInt("EPrice");
                      
			String efeatures = rs.getString("EFeatures");
			int bprice = rs.getInt("BPrice");
			String bfeatures = rs.getString("BFeatures");
			
			String from = rs.getString("From");
			String to = rs.getString("To");
			int seats = rs.getInt("Seats");
			String dtime = rs.getString("DTime");
			
			String rtime = rs.getString("RTime");
	
                        String RDate = rs.getString("RDATE");
	
                        String DDate = rs.getString("DDATE");
	
                        
        fdi = new Flight_Details_Info(FID,fprice,ffeatures,eprice,efeatures,bprice,bfeatures,from,to,seats,dtime,rtime,DDate,RDate);
	
        }
     
     
     
     
     
     
     
    
    return fdi;
}
public   ArrayList<Flight_Details_Info> getallFlightDetails() throws SQLException{

    Flight_Details_Info fdi=null;
 
     String sql = "SELECT * FROM Flight_Details";
     
     ArrayList<Flight_Details_Info> al=new ArrayList<Flight_Details_Info>();
     
     
     PreparedStatement pStmt = conn.prepareStatement(sql);
		
     
	
                ResultSet rs = pStmt.executeQuery();
	while (rs.next() ) {
			
			int FID = rs.getInt("Flight_Id");
			int fprice = rs.getInt("FPrice");
			  String ffeatures = rs.getString("FFeatures");
			
			int eprice = rs.getInt("EPrice");
                      
			String efeatures = rs.getString("EFeatures");
			int bprice = rs.getInt("BPrice");
			String bfeatures = rs.getString("BFeatures");
			
			String from = rs.getString("From");
			String to = rs.getString("To");
			int seats = rs.getInt("Seats");
			String dtime = rs.getString("DTime");
			
			String rtime = rs.getString("RTime");
	
                        String RDate = rs.getString("RDATE");
	
                        String DDate = rs.getString("DDATE");
	
                        
        fdi = new Flight_Details_Info(FID,fprice,ffeatures,eprice,efeatures,bprice,bfeatures,from,to,seats,dtime,rtime,DDate,RDate);
	al.add(fdi);
        }
     
     
     
     
     
     
     
    
    return al;
}





    public boolean isFlightApproved() throws SQLException {
        String sql = "SELECT * FROM Flight_Details WHERE Approved = 1";
        PreparedStatement pStmt=null;
           
        ResultSet rs=null;
      try {
          pStmt = conn.prepareStatement(sql);
       
            rs = pStmt.executeQuery();
      } 
      catch (SQLException ex) {
          Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
      }
;
        if (rs.next()) {
            return true;
        }
        return false;
}


public Flight_Details_Info verifyBookingInfo(String from,String to,String ddate,String rdate ) throws SQLException{
			Flight_Details_Info fdi=null;
                String sql = "SELECT * FROM Flight_Details WHERE [From] = ? AND [To]=? AND DDATE=? AND RDATE=?";
	
        PreparedStatement pStmt = conn.prepareStatement(sql);
        System.out.print("------------------------------------------------------\n\n" + from + to + "\n\n----------------");
        pStmt.setString(1, from);
        pStmt.setString(2, to);

        pStmt.setString(3, ddate);

        pStmt.setString(4, rdate);

        ResultSet rs = pStmt.executeQuery();
        if (rs.next()) {

            int FID = rs.getInt("Flight_Id");
            int fprice = rs.getInt("FPrice");
            String ffeatures = rs.getString("FFeatures");

            int eprice = rs.getInt("EPrice");
            System.out.print("Ab ye dekho " + eprice);
            String efeatures = rs.getString("EFeatures");
            int bprice = rs.getInt("BPrice");
            String bfeatures = rs.getString("BFeatures");

            String from2 = rs.getString("From");
            String to2 = rs.getString("To");
            int seats = rs.getInt("Seats");
            String dtime = rs.getString("DTime");

            String rtime = rs.getString("RTime");

            String RDate = rs.getString("RDATE");

            String DDate = rs.getString("DDATE");

            fdi = new Flight_Details_Info(FID, fprice, ffeatures, eprice, efeatures, bprice, bfeatures, from2, to2, seats, dtime, rtime, DDate, RDate);

        }
        if (!this.isFlightApproved()) {
            fdi = null;
        }
        return fdi;

    }

    public void setBook_Flight(int bid, int fid, String Email, int Price, String Clas) {

        try {
            st = conn.createStatement();
            String sql3 = "insert into Book_Flight values(?,?,?,?,?)";
            
            
                PreparedStatement pStmt = conn.prepareStatement(sql3);
		
                pStmt.setInt(1,bid);
                
                pStmt.setInt(2,fid);
                
                pStmt.setString(3,Email);
                
                pStmt.setInt(4,Price);
                pStmt.setString(5, Clas);
                
           
                ResultSet rs = pStmt.executeQuery();
                
            
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateFlight_Details_Seats(int up) {

        try {
            st = conn.createStatement();
            String sql5 = "UPDATE Flight_Details "
                    + "SET Seats ='" + up + "'";
            st.executeUpdate(sql5);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Book_Flight_Info getBook_Flight()  {

          Book_Flight_Info bfi = null;
      try {
          
          String sql = "SELECT * FROM Book_Flight";
          
          PreparedStatement pStmt = conn.prepareStatement(sql);
          
          ResultSet rs = pStmt.executeQuery();
          if (rs.next()) {
              
              int FID = rs.getInt("Flight_ID");
              
              int BID = rs.getInt("Book_ID");
              
              String email = rs.getString("Email");
              
              int price = rs.getInt("Price");
              
              String clas = rs.getString("Class");
              
              bfi = new Book_Flight_Info(BID, FID, email, price, clas);
              
          }
          
         
      } catch (SQLException ex) {
          Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
      }
 return bfi;














    }


}
