/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author mian
 */
public class VirtualMachine {
    ArrayList <String> TAC= new  ArrayList <String>();
    ArrayList <String> opcode= new  ArrayList <String>();
    ArrayList <Integer> fileopcode= new  ArrayList <Integer>();
    ArrayList <Integer> operand1= new  ArrayList <Integer>();
    ArrayList <Integer> operand2= new  ArrayList <Integer>();
    ArrayList <Integer> destination= new  ArrayList <Integer>();
    ArrayList <String> variablename=  new ArrayList <String>();
    ArrayList <Integer> datasection= new ArrayList <Integer>();
        ArrayList <String> outdatasection= new ArrayList <String>();

    

    public VirtualMachine() {
        for(int i=0; i< 100; i++){
            datasection.add(0);
        }
        
       ReadTac();
       defineopcodes();
       convertTACtoQuadruple();
      
       
        runQuadruple();
       
       int k=1;


       
    }
    void ReadTac()
    {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("TAC.txt"));
			String line = reader.readLine();
			while (line != null) {
				// read next line

                                //System.out.println(line);
                                TAC.add(line);
				line = reader.readLine();
                                
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    void convertTACtoQuadruple()
    {
        for(int i = 0; i <TAC.size(); i++)
        {
            
            if(TAC.get(i).contains("int"))
            {
                fileopcode.add(opcode.indexOf("int"));
                String [] s=TAC.get(i).split(" ");

                variablename.add(s[5]);
                operand1.add(-1);
                operand2.add(-1);
                destination.add(-1);
                
            }
            else if(TAC.get(i).contains("char"))
            {
                fileopcode.add(opcode.indexOf("char"));
                String [] s=TAC.get(i).split(" ");

                variablename.add(s[5]);
                operand1.add(-1);
                operand2.add(-1);
                destination.add(-1);
            }
            else if(TAC.get(i).contains("+"))
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("+"));
                String [] s=TAC.get(i).split(" ");
                boolean alldigits = s[3].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[3]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[3]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[3])==-1)
                    {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                    }
                    operand1.add(variablename.indexOf(s[3]));
                }
                 alldigits = s[7].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[7]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[7]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[7])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[7]));
                }
                variablename.add(s[0]);
                
                destination.add(variablename.size()-1);
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                    System.exit(0);
                    return;
                }
            }
            else if(TAC.get(i).contains("-"))
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("-"));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[3].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[3]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[3]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[3])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[3]));
                }
                 alldigits = s[7].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[7]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[7]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[7])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[7]));
                }
                variablename.add(s[0]);
                
                destination.add(variablename.size()-1);
               
                //destination.add(variablename.indexOf(s[0]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                    
                }
            }
            else if(TAC.get(i).contains("*"))
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("*"));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[3].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[3]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[3]));
                    
                }
                else
                {
                    
                if(variablename.indexOf(s[3])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[3]));
                }
                 alldigits = s[7].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[7]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[7]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[7])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[7]));
                }
                
               variablename.add(s[0]);
                
                destination.add(variablename.size()-1);

                //destination.add(variablename.indexOf(s[0]));
               
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
            else if(TAC.get(i).contains("/"))
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("/"));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[3].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[3]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[3]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[3])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[3]));
                }
                 alldigits = s[7].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[7]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[7]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[7])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[7]));
                }
                
               variablename.add(s[0]);
                
                destination.add(variablename.size()-1);

                //destination.add(variablename.indexOf(s[0]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                    
                }
            }
            else if(TAC.get(i).contains("if") && TAC.get(i).contains(">=") )
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("if>="));
                String [] s=TAC.get(i).split(" ");

                 boolean alldigits = s[2].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[2]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[2]));
                    
                }
                else
                { if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[2]));}
                 alldigits = s[8].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[8]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[8]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[8])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[8]));
                }
                
                destination.add(Integer.parseInt(s[12]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
            else if(TAC.get(i).contains("if") && TAC.get(i).contains("<=") )
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("if<="));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[2].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[2]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[2]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[2]));
                }
                 alldigits = s[8].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[8]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[8]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[8])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[8]));
                }
                

                destination.add(Integer.parseInt(s[12]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
            else if(TAC.get(i).contains("if") && TAC.get(i).contains(">") )
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("if>"));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[2].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[2]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[2]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[2]));
                }
                 alldigits = s[8].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[8]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[8]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[8])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[8]));
                }
                
               

                destination.add(Integer.parseInt(s[12]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
            else if(TAC.get(i).contains("if") && TAC.get(i).contains("<") )
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("if<"));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[2].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[2]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[2]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[2]));
                }
                 alldigits = s[8].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[8]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[8]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[8])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    
                    operand2.add(variablename.indexOf(s[8]));
                }
                

                destination.add(Integer.parseInt(s[12]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
            
            else if(TAC.get(i).contains("if") && TAC.get(i).contains("==") )
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("if=="));
                String [] s=TAC.get(i).split(" ");
                 boolean alldigits = s[2].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[2]);
                    operand1.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[2]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[2]));
                }
                 alldigits = s[8].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[8]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[8]));
                    
                }
                else
                {
                    if(variablename.indexOf(s[8])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand2.add(variablename.indexOf(s[8]));
                }
                

                destination.add(Integer.parseInt(s[12]));
                
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
            else if(TAC.get(i).contains(":=") )
            {
                try{
                
                fileopcode.add(opcode.indexOf(":="));
                String [] s=TAC.get(i).split(" ");

                destination.add(-1);
                
                boolean alldigits = s[7].chars().allMatch(Character::isDigit);
                if(alldigits==true)
                {
                    variablename.add(s[7]);
                    operand2.add(variablename.size()-1);
                    datasection.set(variablename.size()-1,Integer.parseInt( s[7]));
                    
                }
                else
                    
                {
                                        if(variablename.indexOf(s[7])==-1)
                                        {
                                            System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);

                                           

                                        }
                    operand2.add(variablename.indexOf(s[7]));
                }
                if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                operand1.add(variablename.indexOf(s[2]));
                
                
                }
                catch(Exception e)
                {
                                  try{  String [] s=TAC.get(i).split(" ");

                     boolean alldigits = s[6].chars().allMatch(Character::isDigit);
                    if(alldigits==true)
                    {
                        variablename.add(s[6]);
                        operand2.add(variablename.size()-1);
                        datasection.set(variablename.size()-1,Integer.parseInt( s[6]));
                    
                    }
                    else
                    {
                        if(variablename.indexOf(s[6])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                     operand2.add(variablename.indexOf(s[6]));
                    }
                    if(variablename.indexOf(s[2])==-1)
                    {
                        throw new Exception();
                    }
                    if(variablename.indexOf(s[2])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[2]));
                                  }
                                  catch(Exception ex)
                                  {
                                                          System.out.println("Variable Not  Declared at "+i);
                                                            System.exit(0);

                                                          return;

                                  }
                
                }
            }
            else if(TAC.get(i).contains("goto") )
            {
                try{
                    
                
                fileopcode.add(opcode.indexOf("goto"));
                String [] s=TAC.get(i).split(" ");

                destination.add(-1);
                operand1.add(Integer.parseInt(s[1]));
                operand2.add(-1);
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    return;
                }
            }
             else if(TAC.get(i).contains("out"))
            {
                try{
                    fileopcode.add(opcode.indexOf("out"));
                    String [] s=TAC.get(i).split(" ");
                    if(s[5].length()==1)
                    {
                        if(variablename.indexOf(s[5])==-1)
                    {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                                             
                    }
                        outdatasection.add(String.valueOf(variablename.indexOf(s[5])));
                                             operand1.add(outdatasection.size()-1);
                        
                    }
                    else 
                    {
                        outdatasection.add(s[5]);
                         operand1.add(outdatasection.size()-1);

                    }
                                    operand2.add(-1);
                                    destination.add(-1);
                }
                catch(Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);
                    
                }
            }
            else if(TAC.get(i).contains("in"))
            {
                try{
                    fileopcode.add(opcode.indexOf("in"));
                    String [] s=TAC.get(i).split(" ");
                    destination.add(-1);
                    if(variablename.indexOf(s[5])==-1)
                 {
                     System.out.println("Variable Not  Declared at "+i);
                                            System.exit(0);
                 }
                    operand1.add(variablename.indexOf(s[5]));
                operand2.add(-1);

                    
                    
                }
                catch (Exception e)
                {
                    System.out.println("Variable Not  Declared at "+i);
                     System.exit(0);

                    
                }
            }
           
        }
       
    }
    void defineopcodes()
    {
        //the indexes will be the opcodes of the relative operators being added
        opcode.add("int");//for int declaration
        opcode.add("char");//for char declaration
        opcode.add("+");
        opcode.add("-");
        opcode.add("*");
        opcode.add("/");
        opcode.add(":=");
        opcode.add("if>");
        opcode.add("if<");
        opcode.add("if>=");
        opcode.add("if<=");
        opcode.add("if==");
        opcode.add("goto");
        opcode.add("in");
        opcode.add("out");
            
    }
    void runQuadruple()
    {
        for(int i=0;i< TAC.size(); i++)
        {
            if(fileopcode.get(i)==0)//int declaration
            {
                
            }
            else if(fileopcode.get(i)==1)//char declaration
            {
                
            }
            else if(fileopcode.get(i)==2)//addition
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                datasection.set(destination.get(i), firstdigit+seconddigit);

                
            }
            else if(fileopcode.get(i)==3)//subtraction
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                datasection.set(destination.get(i), firstdigit-seconddigit);

            }
            else if(fileopcode.get(i)==4)//multiplication
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                 datasection.set(destination.get(i), firstdigit*seconddigit);

            }
            else if(fileopcode.get(i)==5)//division
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                datasection.set(destination.get(i), firstdigit*seconddigit);

            }
            else if(fileopcode.get(i)==6)//assignment
            {
                                //System.out.println(i);

                int seconddigit=datasection.get(operand2.get(i));
                datasection.set(operand1.get(i),seconddigit);
            }
            else if(fileopcode.get(i)==7)//if>
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                if(firstdigit>seconddigit)
                {
                    i=destination.get(i)-1;
                    
                }
                
            }
            else if(fileopcode.get(i)==8)//if<
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                if(firstdigit<seconddigit)
                {
                    i=destination.get(i)-1;
                    
                }
            }
            else if(fileopcode.get(i)==9)//if>=
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                if(firstdigit>=seconddigit)
                {
                    i=destination.get(i)-1;
                    
                }
            }
            else if(fileopcode.get(i)==10)//if<=
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                if(firstdigit<=seconddigit)
                {
                    i=destination.get(i)-1;
                    
                }
            }
            else if(fileopcode.get(i)==11)//if==
            {
                int firstdigit=datasection.get(operand1.get(i));
                int seconddigit=datasection.get(operand2.get(i));
                if(firstdigit==seconddigit)
                {
                    i=destination.get(i)-1;
                    
                }
            }
            else if(fileopcode.get(i)==12)//goto
            {
                i=operand1.get(i)-1;
                
            }
            else if(fileopcode.get(i)==13)//in
            {
                Scanner a=new Scanner(System.in);
                int val=a.nextInt();
                datasection.set(operand1.get(i),val);
                
            }
            else if(fileopcode.get(i)==14)
            {
                int index=operand1.get(i);
                String value=outdatasection.get(index);
                                 boolean alldigits = value.chars().allMatch(Character::isDigit);
                                 if(alldigits==true)
                                 {
                                     int seconddigit=datasection.get(Integer.parseInt(value));
                                     System.out.println(seconddigit);
                                     
                                 }
                                 else
                                 {
                                     System.out.println(value);
                                 }

                
            }
            
            
            
        }
    }
    
}
