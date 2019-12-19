/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author HafizAhmad
 */

public class  Minesweeper implements Runnable {
 GUI gui=new GUI();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Thread(new Minesweeper()).start();
	}		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true)
		{
			
			gui.repaint();
		
			if(gui.rs==0) {
				gui.checkv();
				
				
			}
			
		}
	}

}
