package minesweeper;

import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.*;

public class GUI extends JFrame{
    
    
    database db;
Date sdate=new Date();
Date edate=new Date();
public int rs=0;
	int spacing=1;
public	int mx=-100;
public	int my=-100;
int neighs=0;
Random rand=new Random();
int [][] mines=new int[16][9];
Image img1;
Image img2;
Image img3;
public int h=1;
int [][] neighbours=new int[16][9];
int [][] revealed=new int[16][9];
int [][] flagged=new int[16][9];
int smx=605;
String wmes="nothing";
int smy=5;
int tx=1100;
int ty=5;
int sec=0;
int hour=0;
int min=0;
int w=0;
int csx=smx+35;

int csy=smy+35;

int savex=105+35;
int savey=5+35;

int loadx=205+35;

int loady=5+35;

int d=0;

public int winx=800;
public int winy=-50;
Image img4;
JButton button;
public GUI() 

{
    db=new database();
	     img1 = Toolkit.getDefaultToolkit().getImage("2.png");

	     img2 = Toolkit.getDefaultToolkit().getImage("c.png");

	     img3 = Toolkit.getDefaultToolkit().getImage("b.png");
	database db=new database();
        
       
        
        
        
this.setTitle("Minesweeper");
this.setSize(1386,829);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
this.setResizable(false);


for(int i=0;i<16;i++) {
	for(int j=0;j<9;j++) {
	
	if(rand.nextInt(100)<20)
	{
		
		mines[i][j]=1;
	}else {
		
		mines[i][j]=0;
		
	}
	
	revealed[i][j]=0;
	
	} 
}



for(int k=0;k<16;k++) {
	for(int l=0;l<9;l++) { 
		neighs=0;
		for(int m=0;m<16;m++) {
			for(int n=0;n<9;n++) {
				//removing itself inclusion
				
				if(!(m==k && n==l)) {
			if(isN(k,l,m,n)==true) 
				neighs++;
				}
				
			}
		}
		neighbours[k][l]=neighs;
	}

}






Board board=new Board();

this.setContentPane(board);

Move move=new Move();
this.addMouseMotionListener(move);
Click click=new Click();
this.addMouseListener(click);



}


public class Board extends JPanel{
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0,1279,900);
		for(int i=0;i<16;i++) {
			for(int j=0;j<9;j++) {
				

				g.setColor(Color.gray);
				
				
//if(mines[i][j]==1) {
					
				//	g.setColor(Color.yellow);
						
					
			//	}
if(revealed[i][j]==1) {
	
	g.setColor(Color.white);
	if(mines[i][j]==1) {
		
		g.setColor(Color.red);
		
		
	}
		
	
}

				/*
if(revealed[i][j]==1) {
					
					g.setColor(Color.yellow);
						
					
				}*/				
				
				
if(mx>=spacing+i*80 && mx<i*80+80-spacing && my>=spacing+j*80+106 && my<spacing+j*80+186-spacing) {
	g.setColor(Color.yellow);
}
					
g.fillRect(spacing+i*80, spacing+j*80+80, 80-2*spacing, 80-2*spacing);				
if(revealed[i][j]==1){
g.setColor(Color.black);
if(mines[i][j]==0 && neighbours[i][j]!=0){
	
	if(neighbours[i][j]==1) {
		g.setColor(Color.blue);
		
	}else if(neighbours[i][j]==2) {
		g.setColor(Color.green);
		
	}else if(neighbours[i][j]==3) {
		g.setColor(Color.red);
		
	}else if(neighbours[i][j]==4) {
		g.setColor(Color.ORANGE);
		
	}else if(neighbours[i][j]==5) {
		
		g.setColor(Color.darkGray);
	}else if(neighbours[i][j]==6) {

		g.setColor(Color.PINK);
		
	}
	
	
g.setFont(new Font("Tahoma",Font.BOLD,40));
g.drawString(Integer.toString(neighbours[i][j]),i*80+27,j*80+80+55);

}else
if(mines[i][j]==1){

//g.fillRect(i*80+10+20,j*80+80+20,20,40);


//g.fillRect(i*80+20,j*80+80+10+20,20,40);

//g.fillRect(i*80+5+20,j*80+80+5+20,20,40);
g.drawImage(img1, i*80+2, j*80+80+2, this);
}

}
			
			} 
			
			
		}
		
		//smil
		g.setColor(Color.yellow);
		g.fillOval(605, 5, 70, 70);
		g.setColor(Color.black);
		g.fillOval(smx+15, smy+20, 10, 10);
		g.fillOval(smx+45, smy+20, 10, 10);
		if(h==1) {
			
			g.fillOval(smx+20, smy+50, 30, 5);
			g.fillOval(smx+17, smy+45, 5, 5);
			g.fillOval(smx+48, smy+45, 5, 5);
			
		}else {
			
			g.fillOval(smx+20, smy+45, 30, 5);
			g.fillOval(smx+17, smy+56, 5, 5);
			g.fillOval(smx+48, smy+50, 5, 5);
			
		}
		//add save
                g.drawImage(img3, 105, 5, this);
                //add load
                   g.drawImage(img2, 205, 5, this);
              
                
		g.setColor(Color.black);
		g.fillRect(tx, ty, 140, 70);
		if(d==0 && w==0)
		sec=(int) ((new Date().getTime()-sdate.getTime())/1000);
		if(sec>999)
			sec=999;
		
		g.setColor(Color.white);
		g.setFont(new Font("Tahoma",Font.PLAIN,80));
		
		if(sec<10) {
			g.drawString("00"+Integer.toString(sec),tx,ty+65);
		}else
			if(sec<100) {

				g.drawString("0"+Integer.toString(sec),tx,ty+65);
			}
			else {
				

				g.drawString(Integer.toString(sec),tx,ty+65);
			}
		
		
		//win show

	
	if(w==1) {
		g.setColor(Color.GREEN);
		wmes="win";
	}
	else {
		if(d==1)
			g.setColor(Color.red);
	wmes="Lose";
	
	}
	
	
	if(w==1 || d==1) {
		winy=-50+(int)(new Date().getTime()-edate.getTime())/10;
		g.drawString(wmes, winx,winy);
	}
	}
	
	
}
public void reset() {
	rs=1;
	sdate=new Date();
	h=1;
	d=0;
	w=0;
	winy=-50;
wmes="nothing";
for(int i=0;i<16;i++) {
	for(int j=0;j<9;j++) {
	
	if(rand.nextInt(100)<20)
	{
		
		mines[i][j]=1;
	}else {
		
		mines[i][j]=0;
		
	}
	
	revealed[i][j]=0;
	flagged[i][j]=0;
	} 
}



for(int k=0;k<16;k++) {
	for(int l=0;l<9;l++) { 
		neighs=0;
		for(int m=0;m<16;m++) {
			for(int n=0;n<9;n++) {
				//removing itself inclusion
				
				if(!(m==k && n==l)) {
			if(isN(k,l,m,n)==true) 
				neighs++;
				}
				
			}
		}
		neighbours[k][l]=neighs;
	}

}

rs=0;
}

public void checkv() {
	
	if(d==0) {
	for(int m=0;m<16;m++) {
		for(int n=0;n<9;n++) {
	if(revealed[m][n]==1 && mines[m][n]==1)
		d=1;
	h=0;
	edate= new Date(); 
		}
		
	}
	}	
	if(tboxr()>=144-tmine()&& w==0)
	{
		w=1;
		edate= new Date(); 
	}
}

public int tboxr() {int t=0;
for(int m=0;m<16;m++) {
	for(int n=0;n<9;n++) {
if(revealed[m][n]==1)
	t++;
	}
	
}

return t;}
public int tmine() {
	int t=0;
	for(int m=0;m<16;m++) {
		for(int n=0;n<9;n++) {
	if(mines[m][n]==1)
		t++;
		}
		
	}
	
	return t;}

public boolean insave() {
	
	int dif=(int)Math.sqrt(Math.abs(mx-savex)*Math.abs(mx-savex)+Math.abs(my-savey)*Math.abs(my-savey));
	if(dif<35)
		return true;
	return false;
}
		
public boolean insm() {
	
	int dif=(int)Math.sqrt(Math.abs(mx-csx)*Math.abs(mx-csx)+Math.abs(my-csy)*Math.abs(my-csy));
	if(dif<35)
		return true;
	return false;
}



public boolean inload() {
	
	int dif=(int)Math.sqrt(Math.abs(mx-loadx)*Math.abs(mx-loadx)+Math.abs(my-loady)*Math.abs(my-loady));
	if(dif<35)
		return true;
	return false;
}
public class Move implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

		mx=e.getX();
		my=e.getY();
		
		
	/*	System.out.println("The mouse was moved");
		mx=e.getX();
		my=e.getY();
	
	System.out.println("X:  ="+mx+"   Y:  ="+my);
	}*/
	
	
	
	
}

}




public class Click implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		
		mx=e.getX();
		my=e.getY();

		if(inBoxX()!=-1 && inBoxY()!=-1) {
			
		revealed[inBoxX()][inBoxY()]=1;
		
		}
		
		if(insm()==true)
			reset();
		
		
        
        
        
        
        
        
         if(insave()==true){
                    try {
                        db.save(revealed,mines, 16);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
if(inload()==true){
                    try {
                        db.load(revealed,mines ,16);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        
        
        
        
        
        
        
        }
       

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	



}


public int inBoxX() {
	for(int i=0;i<16;i++) {
		for(int j=0;j<9;j++) {
			
if(mx>=spacing+i*80 && mx<i*80+80-spacing && my>=spacing+j*80+106 && my<spacing+j*80+186-spacing) {
				
				return i;
			}
		} 

	}
	return -1;
	
	
}


public int inBoxY() {
	
	

	for(int i=0;i<16;i++) {
		for(int j=0;j<9;j++) {
			
if(mx>=spacing+i*80 && mx<i*80+80-spacing && my>=spacing+j*80+106 && my<spacing+j*80+186-spacing) {
				
				return j;
			}
		} 

	}

	return -1;
	
	
	
	
}

public boolean isN(int mX,int mY,int cX,int cY) {
	//end statement not include itself
	if(mX-cX<2&&mX-cX>-2 && (mY-cY<2 && mY-cY>-2) && mines[cX][cY]==1) {
		return true;
		
		
	}
	return false;
}


}/*


}


*/