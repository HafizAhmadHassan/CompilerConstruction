/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author HafizAhmad
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getflight")
    public String getflight(@WebParam(name = "from") String From,@WebParam(name = "to") String To,@WebParam(name = "ddate") String Ddate,@WebParam(name = "rdate") String Rdate) {
        ArrayList<Flight_Details_Info> fdi=null;
     String fd="Ahmad Here You go";       
        try {
            database db=new database();
            fdi=db.getallFlightDetails();
        if(fdi!=null){
        
            for(int i=0;i<fdi.size();i++){
            if(fdi.get(i).From.equals(From) && fdi.get(i).To.equals(To) && fdi.get(i).DDATE.equals(Ddate) && fdi.get(i).RDATE.equals(Rdate) )
                fd=fd+fdi.get(i).Flight_Id+','+fdi.get(i).DTime+','+fdi.get(i).RTime+','+fdi.get(i).EPrice+','+fdi.get(i).FPrice+','+fdi.get(i).BPrice+'\n';
            }
                }
        } catch (SQLException ex) {
            Logger.getLogger(NewWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    return fd;
    
    
    }





}
