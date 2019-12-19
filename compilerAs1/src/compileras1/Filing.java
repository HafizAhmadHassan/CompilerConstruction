/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compileras1;
import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader; 
import java.io.File; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author hafizahmad
 */
  
//Displaying the contents of a directory 
class Filing 
{ 

    
public String [] FilingRead(String filename) {
	BufferedReader reader;
	try {
            
            
            int columns=this.getFileLines(filename);
            
            reader = new BufferedReader(new FileReader(filename));
             String[] newArray = new String[columns];
             int i=0;
             String line = reader.readLine();
		while (line != null) {
				// read next line
                        newArray[i]=line +'\n';
			line = reader.readLine();
                        i=i+1;
		
                }
                reader.close();
                return newArray;
		
	} catch (IOException e) {
		e.printStackTrace();
                return null;
        }
}
    
public int getFileLines(String filename) {
    int c=0;	
    	BufferedReader reader;
	try {
            
            
            String line= " ";
            reader = new BufferedReader(new FileReader(filename));
           	while (line != null) {
				// read next line
                        line = reader.readLine();
                        c=c+1;
                }
            reader.close();
            	
	} catch (IOException e) {
		e.printStackTrace();
            
        }
    return c+2;
}


   
}
 