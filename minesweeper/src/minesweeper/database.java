/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HafizAhmad
 */
public class database {
   
    Connection conn;
     Statement stmt;
      ResultSet rs;
    
    database(){
        try{
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
     conn=DriverManager.getConnection("jdbc:ucanaccess://mine.accdb");
      stmt = conn.createStatement(); 
      ResultSet rs=null;
    
    }catch(Exception e){
    System.out.print(e);
    
    }
    }
    
   public void save(int s[][],int r[][],int row) throws SQLException{
       
       for(int i=0;i<row;i++){
  String sql3= "insert into minetable values('"+s[i][0]+"','"+s[i][1]+"','"+s[i][2]+"','"+s[i][3]+"','"+s[i][4]+"','"+s[i][5]+"','"+s[i][6]+"','"+s[i][7]+"','"+s[i][8]+"')";
      stmt.executeUpdate(sql3);
  String sql4= "insert into minetable2 values('"+r[i][0]+"','"+r[i][1]+"','"+r[i][2]+"','"+r[i][3]+"','"+r[i][4]+"','"+r[i][5]+"','"+r[i][6]+"','"+r[i][7]+"','"+r[i][8]+"')";
      stmt.executeUpdate(sql4);
  
       
       }
       
   
   } 
    
      public void load(int s[][],int r[][],int row) throws SQLException{
       
 String sql = "SELECT * FROM minetable";
       rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      int i=0;
      while(rs.next()){
         //Retrieve by column name
         
         s[i][0] = rs.getInt("c1");
         s[i][1]  = rs.getInt("c2");
          s[i][2] = rs.getInt("c3");
           s[i][3]= rs.getInt("c4");
           s[i][4]= rs.getInt("c5");
           s[i][5]= rs.getInt("c6");
           s[i][6]= rs.getInt("c7");
           s[i][7]= rs.getInt("c8");
           s[i][8]= rs.getInt("c9");
          

         //Display values
      i++;
      }
      i=0;
     
        
 String sql2 = "SELECT * FROM minetable2";
      rs = stmt.executeQuery(sql2);
     
      
      
      
      while(rs.next()){
         //Retrieve by column name
         
         r[i][0] = rs.getInt("c1");
         r[i][1]  = rs.getInt("c2");
          r[i][2] = rs.getInt("c3");
           r[i][3]= rs.getInt("c4");
           r[i][4]= rs.getInt("c5");
           r[i][5]= rs.getInt("c6");
           r[i][6]= rs.getInt("c7");
           r[i][7]= rs.getInt("c8");
           r[i][8]= rs.getInt("c9");
          

         //Display values
      i++;
      }
      
      
      i=0;
      
      
      
      
      
      
      rs.close();
       
   
   } 
    
    
}
