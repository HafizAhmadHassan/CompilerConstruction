/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author hafizahmad
 */

public class Tokenizer {
       Storge S;
       int ip;
       String k;
       String lexeme;
       int state;
       boolean kflag;
       String fileContents;
       Test stak; 
       Stack<String> stack;
       int previousip;
       String keyword;
       String line;
       String brac;
       String Qomma;
       String semiCol;
       String strings;
       String ids;
    /**
     * @param args the command line arguments
     */
    //public static String [] currentline;
    public Tokenizer(){
    S = new Storge();
    k = new String();
    String ids=new String();
    lexeme=new String();
    stak = new Test();
    stack = new Stack<String>();
    fileContents = new String();
    state =1;
    previousip=0;
    keyword = new String();
    Qomma = new String();
    brac = new String();
    semiCol = new String();
    strings = new String();
    }
    public void storeFileContents(String [] m){
    for(int i = 0; i< m.length;i++){
    fileContents = fileContents + m[i];
     line=fileContents;
    }
        
        
    }
    public boolean isLetter(char let){
        if((let >= 'a' && let <= 'z') || (let >= 'A' && let <= 'Z') ){
        return true;
        }
        return false;
    }
    
    public boolean isDigit(char dig){
        if((dig >= '0' && dig <= '9')){
        return true;
        }
        return false;
    }

    public boolean isOther(char Oth){
        if(!isLetter(Oth) && !isDigit(Oth)){
        return true;
        }
        return false;
    }
      public boolean arithmetic_operators(String k){
    
    return false;
    }
    
    public boolean rational_operators(String k){
    
    return false;
    
    }
    
    
    public boolean isEverythingExceptNewLine(char k){
    if(k!= '\n'){
    return true;
    }
    
    return false;
    }
    
    public boolean multi_comment(char k){
    
    
    return false;
    }
    public void done(String n ,String m){
    
             ip=previousip-1;
             lexeme = lexeme + "( "+ n + " , " + m +" )\n";
             if(m.equals("id")){
             ids = ids + n +"\n";
             
             }
             keyword=new String();
             brac = new String();
             Qomma = new String();
             semiCol = new String();
             strings = new String();
//  System.out.println(ip);
            
             state=1;
               
        
    }
    public String id() throws InterruptedException, FileNotFoundException, UnsupportedEncodingException{
        
        for(ip=previousip;ip < line.length();ip++){
            
            
//if(line.charAt(ip)== ' ' || line.charAt(ip)== '\n' ){
            //kflag = false;

            //}else{
           // kflag= true;
            //}
           // if(kflag==true ){
          //  k= k + line.charAt(ip);
        //    }
            
            switch(state){
                case 1:
                    if(isLetter(line.charAt(ip))){
                        
                        //System.out.println(" Hi ");
                        state=2;
                        keyword = keyword + line.charAt(ip); 
                    }
                    else if(line.charAt(ip) == '#'){
                    //System.out.print(state);
                        state=13;
                   //System.out.print("\n "+ state + "Computing");
                    }
                    else if(line.charAt(ip)== ';'){
                    semiCol=semiCol + line.charAt(ip);
                        state = 7;
                    }else if(line.charAt(ip)== ' ' || line.charAt(ip)== '\n'){
                    //System.out.println("Hi " + line.charAt(ip));
                    //previousip= previousip +1;
                    //state =1;
                    //ip =ip +1;
                    }
                    else if(line.charAt(ip) == '+' || line.charAt(ip) == '-' || line.charAt(ip) == '*' || line.charAt(ip) == '/'){
                     strings =strings+line.charAt(ip);
                     state = 8;
                    
                    }else if(line.charAt(ip) == '<' || line.charAt(ip) == '>'){
                    strings = strings +line.charAt(ip);
                    state = 9;
                    }
                    else if(line.charAt(ip) == '=' || line.charAt(ip) == '!'){
                    state = 11;
                    strings = strings+ line.charAt(ip);
                    }else if (line.charAt(ip)== '\''){
                    state = 19;
                    }else if (line.charAt(ip)== ':'){
                    
                    strings = strings + line.charAt(ip);  
                   // System.out.println(state);
                    state = 28;
                    }else if(line.charAt(ip)==','){
                    Qomma = Qomma + line.charAt(ip);
                    state =27;
                    }
                    else if(line.charAt(ip)== '"'){
                   // System.out.print(state);
                        state =22; 
                    }
                    else if(line.charAt(ip)== '{'){
                    brac=brac+ line.charAt(ip);
                    
                     
                    state =30;
                    }
                    else if(line.charAt(ip)== '}'){
                    brac=brac+ line.charAt(ip);
                 
                        state =30;
                    }
                    else if(line.charAt(ip)== '('){
                    brac=brac+ line.charAt(ip);
                    //previousip=ip;
                   // System.out.println("Hello");
                        state =31;
                    }
                    else if(line.charAt(ip)== ')'){
                   // previousip=ip;
                        brac=brac+ line.charAt(ip);
                    
                        state =31;
                    }else if (isDigit(line.charAt(ip))){
                    strings = strings + line.charAt(ip);
                    state = 35;
                    }
                    else
                    { 
                        strings= strings + line.charAt(ip);
                        state=34;
                    }
                    break;
                case 2:
                    if(isLetter(line.charAt(ip)) || isDigit(line.charAt(ip))){
                    
                        keyword = keyword + line.charAt(ip);
                        
                     //   System.out.println(line.charAt(ip)+  " " + "Hi2 ");
                    }
                    if(isOther(line.charAt(ip))){
                        previousip=ip;
                     state =3;
                    }
                    break;
                case 3:
                    //System.out.println(k + "\n Hello2 \n");
                    //k = k.substring(0, k.length()-1);
                    
                     
                      
                    if(S.isKeyword(keyword)){
                    
                        done(keyword,"kw");
                    
                    }
                    else if(S.isDataType(keyword)){
                        done(keyword,"kw");
                    }
                    else if(!S.isDataType(keyword) && !S.isKeyword(keyword)){
   
                        done(keyword,"id");
                     }
                    break;
                case 7: 
                    previousip=ip;
                     done(semiCol,"^");
                    break;
                
                case 8:
                   previousip=ip;
                    done(strings,"^");
                    break;
                case 9:
                    if(line.charAt(ip)== '='){
                    strings = strings + line.charAt(ip);
                        state = 10;
                    }
                    else if(line.charAt(ip) != '='){
                    previousip = ip;
                    done(strings,"RO");
                    }
                    break;
                case 10:
                    previousip = ip;
                    done(strings,"RO");
                    break;
                case 11:
                    if(line.charAt(ip)== '='){
                    strings = strings + line.charAt(ip);
                    
                    state =12;
                    }else{
                    previousip=ip;
                    done(strings,"error");
                    }
                    break;
                case 12:
                    previousip = ip;
                    done(strings,"RO");
                    break;
                case 13:
                    if(line.charAt(ip)!='#'){
                    strings = strings + line.charAt(ip);
                    state = 14;
                    }else if(line.charAt(ip)=='#'){
                     state = 16;
                    }
                    break;
                case 14:
                    if(isLetter(line.charAt(ip)) || isDigit(line.charAt(ip)) || line.charAt(ip)== ' '){
                    strings = strings + line.charAt(ip);
                    }
                    else{
                    previousip= ip;
                    state = 15;
                    }
                    break;
                case 15:
                    
                    done(strings,"Single Comment");
                    break;
                case 16:
                    if(line.charAt(ip)!='#'){
                    strings = strings + line.charAt(ip);
                    }
                    else{
                    state=17;
                    }
                    break;
                case 17:
                    if(line.charAt(ip)=='#'){
                    state = 18;
                    }
                    break;
                case 18:
                    previousip= ip;
                    strings=strings.replace("\n", " ");
                    done(strings,"double Comment");
                case 19:
                    if(isLetter(line.charAt(ip))){
                    strings=strings+line.charAt(ip);
                     state = 20;
                    }
                    break;
                case 20:
                    if(line.charAt(ip)== '\''){
                    state = 21;
                    
                    }
                case 21:
                    previousip = ip+1;
                    done(strings,"LiteralConstant");
                  
                // done("Single Qoute");
                    
                case 22:
//                    
                    if(isLetter(line.charAt(ip)) || isDigit(line.charAt(ip))){
                    strings= strings + line.charAt(ip);
                    }
                    else if(line.charAt(ip)=='"'){
                    state = 23;
                    }
                    break;
                case 23:
                    previousip=ip;
                    done(strings,"String");
                    break;
//                    
//                    if(line.charAt(ip)== 't'){
//                    state = 32;
//                    }
                case 32:
//                    
//                    if(line.charAt(ip)== ' '){
//                    state = 24;
//                    }
                case 24:
                    
                    if(line.charAt(ip)== '"'){
                    state = 25;
                    }
                case 25:
                   
                    if(isLetter(line.charAt(ip)) || isDigit(line.charAt(ip))){
                    strings =strings + isLetter(line.charAt(ip));
                    }
                    else if(line.charAt(ip)=='"'){
                    state =26;
                    }
                    
                case 26:
                    
                    previousip =ip;
                    done(strings,"String");
                    break;
                case 27:
                 //   done(",","Qomma");
                   // break;
                    
                    previousip =ip;
                    done(Qomma,"^");
                    break;
                case 28:
                    if(line.charAt(ip)== '='){
                    strings = strings + line.charAt(ip);  
                    
                    state = 29;
                    
                    }
                 //   System.out.println(state);
                    break;
                case 29:
                  previousip = ip;
                  done(strings,"Assign Op");
                  break;
                case 30 :
                   // done("bracket");
                case 31 :
                    previousip =ip;
                   
                    done(brac,"^");
                    break;
                case 34:
                   // System.out.println("error"+line.charAt(ip));
                    previousip = ip;
                    
                     done(strings,"error");
                    
                    break;
                case 35:
                    if(isDigit(line.charAt(ip))){
                    strings = strings + line.charAt(ip);
                    }
                    else{
                    state = 36;
                     previousip= ip;
                    
                    }
                    break;
                case 36:
                    done(strings,"Integer");
                    
             
            
        }
 
    }
        PrintWriter writer1 = new PrintWriter("symbol_Table.txt", "UTF-8");
        PrintWriter writer2 = new PrintWriter("words.txt", "UTF-8");
        writer1.println(ids);
        writer2.println(lexeme);
        writer1.close();
        writer2.close();
           return null;
 
}
}
