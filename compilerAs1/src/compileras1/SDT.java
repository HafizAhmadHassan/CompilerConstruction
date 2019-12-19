/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hafizahmad
 */
public class SDT {
  String [] myFile;
  String storage;
  int line;
  int [] v;
  String aE;
  int ad;
  String [] n;
  String iff;
  int count =0;
  FileWriter myw;
  FileWriter myw2 ;
  String ts;
  int bytes;
  public SDT() throws IOException{
    
   
    line =0;
    storage =new String();
    v= new int[2000];
    ad=0;
    aE=new String();
    n= new String[256];//Ascii
    count=0;
    iff=new String();
        bytes=0;
    myw = new FileWriter("TAC.txt");
    myw2 =new FileWriter("translator-symboltable.txt");
   ts=new String();
    }
  
  public void initString(int f){
     
   myFile = new String[f+2000];
    for(int i=0;i<(f+2000)-1;i++){
        
    myFile[i]=new String();
    if(i<256){
    n[i]=new String();
    }
    }
  
  }
    /**
     *
     * @param s
     * @param v=-2
     */
    public void addString(String p){
        storage = storage+" "+p;
    }
    public void AssignStored(String p){
        storage = p;
    }
    public void wipeString(){
    storage =new String();
   
    n= new String[256];
    }
      public void addaEString(String p){
        aE = aE+" "+p;
    }
    public void emit(String s){
   
       myFile[this.line] = myFile[this.line] + s;
      // System.out.println("--------- \n"+s +"  "+ this.line+"\n----------------");
       
       line = line+1;
       
   }
    
    public void saveLine(int i){
        
        v[i]=line-1;
       
   }
    
    public void backPath(int line,int l){
    
       myFile[line]=myFile[line]+" "+String.valueOf(l);
   
   }
    public int getLine(){
    return line;
    }
    public void incLine(){
        
        line=line+1;
   
   }
    public String getStored(){
        String s= storage;
        storage=new String();
        return s;
   
   }
    public void print() throws IOException{
    for(int i=0;myFile[i]!=null;i++){
        if(myFile[i].length()>=1){
    //System.out.println(String.valueOf(i) +" "+ myFile[i]);
    myw.append(myFile[i]+'\n');
        }
        
    }
    
    myw2.write(ts);
   // System.out.print(ts);
    myw2.close();
    myw.close();
    }
    
    
    
}
