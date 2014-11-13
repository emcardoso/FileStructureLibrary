package gui.shapes;

import gui.graphics.Drawable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Rect implements Drawable{
	     
	     private int x,y,w,h;
	     private Color c;
	          	     
	     public Rect(int x, int y, int w, int h, Color c){
	        this.x = x;
	        this.y = y;
	        this.w = w;
	        this.h = h;
	        this.c = c;
	     }
	     
	     public void set(Color c){
	         this.c = c;
	     }
	     
	    public void mouseClicked(MouseEvent e){
	    	JOptionPane.showMessageDialog(null, " Fui clicado: x = " + x + " y  = " + y + " cor = " + c.toString() );
	    }
	     
	    public void mouseEnter(){}
	    public void mouseExit(){}
	    public void mouseDrag(int x, int y, int x1, int y1){}
	    
	    
	    public void draw(Graphics g){
	        g.setColor(c);
	        g.fillRect(x, y, w, h);
	    }

		
		public boolean inBounds(int x1, int y1) {
			return (x1 >= x) && (x1 <= x+w) && (y1 >= y) && (y1 <= y+h); 
		}
	}

