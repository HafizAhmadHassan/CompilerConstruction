/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compileras1;

/**
 *
 * @author hafizahmad
 */
import java.io.*; 
import java.util.*; 
  
class S
{    
    // Pushing element on the top of the stack 
   public static void stack_push(Stack<Integer> stack) 
    { 
        for(int i = 0; i < 5; i++) 
        { 
            stack.push(i); 
        } 
    } 
      
    // Popping element from the top of the stack 
   public static void stack_pop(Stack<Integer> stack) 
    { 
        System.out.println("Pop :"); 
  
        for(int i = 0; i < 5; i++) 
        { 
            Integer y = (Integer) stack.pop(); 
            System.out.println(y); 
        } 
    } 
  
    // Displaying element on the top of the stack 
   public static void stack_peek(Stack<Integer> stack) 
    { 
        Integer element = (Integer) stack.peek(); 
        System.out.println("Element on stack top : " + element); 
    } 
      
    // Searching element in the stack 
    public static void stack_search(Stack<Integer> stack, int element) 
    { 
        Integer pos = (Integer) stack.search(element); 
  
        if(pos == -1) 
            System.out.println("Element not found"); 
        else
            System.out.println("Element is found at position " + pos); 
    } 
  
  

} 