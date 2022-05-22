package com.gebilaoyi.j2se.lesson1;

import java.awt.* ;
import javax.swing.* ;

public class HsSnow extends JFrame {

	HsSnow(String title) {	
	
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;	
		this.setTitle(title) ;
		this.setSize(width , height) ;
		this.setDefaultLookAndFeelDecorated(true) ;
		
		MyPanel mp = new MyPanel() ;
		this.add(mp) ;				
		
//		new Thread(mp).start() ;
		
		Thread t = new Thread(mp) ;
		t.start() ;
	}
	public static void main(String[] args) {
		HsSnow hs = new HsSnow("雪花") ;
		
		hs.setVisible(true) ;
	}
}

class MyPanel extends JPanel implements Runnable {
	
	int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
	int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
	
	int num = 450 ;
	int sleep = 40 ;
	
	int[] x = new int[num] ;
	int[] y = new int[num] ;	
	
	int x1 = 600 , y1 = 100 ;
	  
	MyPanel() {	
		for (int i = 0; i<num; i++) {
			x[i] = (int)(Math.random() * width) ;
			y[i] = (int)(Math.random() * height) ;
		}
	}
	public void paint(Graphics g) {
		super.paint(g) ;
		
		this.setBackground(Color.BLACK) ;
		
		g.setColor(Color.WHITE) ;
		for (int i = 0; i<num/4; i++) {
			
			g.drawString("*" ,x[i] , y[i]) ;
		}	
		
		g.setColor(Color.RED) ;
		for (int i = num/4; i<num/2; i++) {
			
			g.drawString("*" ,x[i] , y[i]) ;
		}	
		
		g.setColor(Color.YELLOW) ;
		for (int i = num/2; i<num*3/4; i++) {
			
			g.drawString("*" ,x[i] , y[i]) ;
		}	
		
		g.setColor(Color.BLUE) ;
		for (int i = num*3/4; i<num; i++) {
			
			g.drawString("*" ,x[i] , y[i]) ;
		}	
		
		
		g.setColor(Color.ORANGE) ;	
		g.fillOval(x1 , y1 , 180 , 180) ;
		g.setColor(Color.BLACK) ;
		g.fillOval(x1 - 20 , y1 + 20 , 180 , 180) ;
	}
	
	public void run() {	
		while(true) {	
			for (int i = 0; i<num; i++) {
				y[i] ++ ;
				x[i] -- ;
				
				if(Math.random()>0.5) {
					x[i] ++ ; //x[i] ++ ;
				//	x[i] ++ ; x[i] ++ ;
				}else{
					x[i] -- ; //x[i] -- ;
				//	x[i] -- ; x[i] -- ;
				}
				if(Math.random()>0.5) {
					y[i] ++ ; //y[i] ++ ;
				//	y[i] ++ ; y[i] ++ ;
				}else{
					y[i] -- ; //y[i] -- ;
				//	y[i] -- ; y[i] -- ;

				}
				
				if(y[i] > height) {
					y[i] = 0 ;
				}
				if(x[i] < 0 ) {
					x[i] = width ;
				}
			}
			
			try{
				Thread.sleep(sleep) ;
			}catch(Exception e){
				e.printStackTrace() ;
			}
			
			this.repaint() ;
		}
		
		
	}	
}