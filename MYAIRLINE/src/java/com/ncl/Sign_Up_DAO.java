package com.ncl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sign_Up_DAO {

	
	public Sign_Up_Info searchPerson(String sName){
		Sign_Up_Info person = null;
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:FlightSystemDSN";
		Connection con = DriverManager.getConnection(url);
		String sql = "SELECT * FROM Sign_Up WHERE Email = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,sName);
		ResultSet rs = pStmt.executeQuery();
		if (rs.next() ) {
			
			System.out.println("inside SignUp DAo");
			String name = rs.getString("Email");
			String add = rs.getString("Password");
			String pNum = rs.getString("First_Name");
			String pNum2 = rs.getString("Last_Name");
			
			person = new Sign_Up_Info(pNum,pNum2,name, add);
			con.close();
			}
		}catch(Exception ex){
			
			System.out.println(ex);
			
		}
			return person;
		
	}

	
}
