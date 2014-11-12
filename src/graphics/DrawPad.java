package graphics;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;  

public class DrawPad extends JPanel  implements MouseListener{

      private Drawable shapes[]; 
   
      public DrawPad(){
          super();         
      }
      
      public DrawPad(int h, int w){
          this();
          setPreferredSize(new Dimension(h,w));
      }
      
      public DrawPad(int h, int w, Drawable d[]){
          super();
          setPreferredSize(new Dimension(h,w));
          shapes = d;
      }
      
      
      
      public void paintComponent(Graphics g) {
        super.paintComponent(g);  
        for(int i = 0; i< shapes.length; i++){
           shapes[i].draw(g);
        }
      }

	public void mouseClicked(MouseEvent e) {
		   int x = e.getX();
       	   int y = e.getY();
       	   for(int i =0; i < shapes.length; i++){
       	       if(shapes[i].inBounds(x, y)){
       	           shapes[i].mouseClicked(e);
       	       }
       	    }  
    }  	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	} 
}
