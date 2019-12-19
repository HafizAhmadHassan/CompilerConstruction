/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;

import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author hafizahmad
 */
public class Storge {
     ArrayList list; 
     ArrayList list2; 
     
 
    public Storge(){
      list = new ArrayList();
      list2 = new ArrayList();
      
      list.add( "ret" );
      list.add("if");
      
      list.add("else");
      
      list.add("while");
      
      list.add("in");
      
      list.add("out");
      list2.add("int");
      list2.add("char");
    }
    
    public boolean isKeyword(String k){
     boolean ans = list.contains(k);
     return ans;
    }
    
    public boolean isDataType(String k){
     boolean ans = list2.contains(k);
     return ans;
    }
}
