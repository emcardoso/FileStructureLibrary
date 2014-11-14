package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gui.graphics.*;
import gui.shapes.*;

import javax.swing.event.*; 
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;  


public class Drawing extends JFrame{
    
    public Drawing(){
        Drawable d[] = new Drawable[8];
        d[0] = new Rect(100,100,80,80,new Color(255,0,0));
        d[1] = new Rect(181,100,80,80,new Color(0,255,0));
        d[2] = new Rect(262,100,80,80,new Color(0,0,255));
        d[3] = new Rect(343,100,80,80,new Color(255,0,255));
        d[4] = new Rect(424,100,80,80,new Color(0,255,255));
        d[5] = new JumpEdge(140, 100, 221, 100, 50, new Color(0,0,0)); //padrao(ponto de origem x, ponto de origem y, ponto de destino x, ponto de destino y, altura)
        d[6] = new JumpEdge(230, 100, 383, 100, 45, new Color(0,0,0));
        d[7] = new JumpEdge(302, 100, 464, 100, 55, new Color(0,0,0));
               
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DrawPad canvas = new DrawPad(600,600,d);
        canvas.addMouseListener(canvas);
        
        canvas.setBackground(new Color(255,255,255));
        JScrollPane scrool = new JScrollPane(canvas,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        
        add(scrool);
        
        this.setSize(200, 200);
        pack();
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               Drawing d = new Drawing();
            }
        });
    }

}