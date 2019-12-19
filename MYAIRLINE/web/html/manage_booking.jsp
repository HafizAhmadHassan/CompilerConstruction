

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>






<%
// establishing conection


			String name ="";
			String add ="";
			String pNum ="";
			String pNum2 ="";
			
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:FlightSystemDSN";
		Connection con = DriverManager.getConnection(url);
		String sql = "SELECT * FROM Booking WHERE Reference_ID = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1,request.getParameter("myid"));
		ResultSet rs = pStmt.executeQuery();
		if (rs.next()) {
			
			 name = rs.getString("Email");
		 add = rs.getString("Price");
		 pNum = rs.getString("Booking_Id");
	     pNum2 = rs.getString("Reference_Id");
			
			con.close();
			}
		
		
		}catch(Exception ex){
			
			System.out.println(ex);
			
		}

%>



<p>
<%=name %>
</p>>

<p>
<%=add %>
</p>>
<p>
<%=pNum %>
</p>>








</body>
</html>