package com.ncl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Flight_Table_DAO {
	
	public Flight_Table_Info searchPerson(String sName){
		Flight_Table_Info ft = null;
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:FlightSystemDSN";
		Connection con = DriverManager.getConnection(url);
		String sql = "SELECT * FROM Flight_Details WHERE From = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,sName);
		ResultSet rs = pStmt.executeQuery();
		
		
		if (rs.next() ) {
			
			String rtime = rs.getString("RTime");
			String price = rs.getString("Price");
			String dtime = rs.getString("DTime");
			String seats = rs.getString("Seats");
			System.out.println(rtime+price+dtime+seats);
			ft = new Flight_Table_Info(rtime,price,dtime, seats);
			con.close();
			}
		}catch(Exception ex){
			
			System.out.println(ex);
			
		}
			return ft;
		
	}


}
