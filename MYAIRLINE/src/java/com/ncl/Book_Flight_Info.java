/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncl;

/**
 *
 * @author HafizAhmad
 */
public class Book_Flight_Info {
     public int BID;
   
   public int  FID;
    
   public String Email;
   
   public int Price;
   
   public String Clas;
   
           
   Book_Flight_Info(  int BID,
   
    int  FID,
    
   String Email,
   
  int Price,
   
   String Clas
   ){
   
   
   this.BID=BID;
   this.Clas=Clas;
   this.Email=Email;
   this.Price=Price;
   this.FID=FID;
             
}
}
