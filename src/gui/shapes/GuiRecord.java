package gui.shapes;

import gui.graphics.Drawable;

import java.awt.Color;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class GuiRecord extends Rect {

	private int id;
	private GuiRecord next;
	
	public GuiRecord(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
		next = null;
		
					
	}
	
	public void setNext(GuiRecord n){
		next = n;
	}
	
	public GuiRecord getNext(){
		return next;
	}
}
