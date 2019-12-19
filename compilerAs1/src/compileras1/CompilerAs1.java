/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author hafizahmad
 */
public class CompilerAs1 {
    
    
   
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException, IOException {
        
                        
        Parser1 p =new Parser1(args[0]);
        p.sdtPrint();
        VirtualMachine vm= new VirtualMachine();
        
        
       
        
        
    }
    
    
}
