package shapes;

import graphics.Drawable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class JumpEdge implements Drawable{
	
		private int x,y,w,z,h;
		private Color c;
		
		public JumpEdge(int x, int y, int w, int z, int h , Color c){
			this.x = x;          // X origem          
			this.y = y;          // Y origem
			this.w = w;          // X destino
			this.z = z;          // Y destino
			this.h = h;          // Altura da aresta 
			this.c = c;          
		}
		
		public void set(Color c){
			this.c = c;
		}
		
		public void draw(Graphics g){
			g.setColor(c);
			//Desenhar Arestas
			g.drawLine(x,y,x,y-h);
			g.drawLine(x,y-h,w,z-h);
			g.drawLine(w,z-h,w,z);
			
			//Desenhar Seta
			int[] xpoints = {w, w-5, w+5};
		    int[] ypoints = {z, z-10, z-10};
											    
		    g.fillPolygon(xpoints, ypoints, 3);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDrag(int x, int y, int x1, int y1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEnter() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExit() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean inBounds(int x, int y) {
			// TODO Auto-generated method stub
			return false;
		}

}
