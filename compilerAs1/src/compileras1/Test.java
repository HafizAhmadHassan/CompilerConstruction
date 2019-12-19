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

class Test 
{ 
	// Pushing element on the top of the stack 
	public void stack_push(Stack<String> stack, String i) 
	{ 
			stack.push(i);  
	} 
	
	// Popping element from the top of the stack 
	public void stack_pop(Stack<String> stack) 
	{ 
		System.out.println("Pop :"); 

		String y = (String) stack.pop(); 
		System.out.println(y); 
	} 

	// Displaying element on the top of the stack 
	public void stack_peek(Stack<String> stack) 
	{ 
		  
            String element = (String) stack.peek();
		System.out.println("Element on stack top : " + element); 
	} 
	
	// Searching element in the stack 
	public int stack_search(Stack<String> stack, String element) 
	{ 
		int pos = (int) stack.search(element); 

                return pos;
        } 


} 
