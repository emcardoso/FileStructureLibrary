package gui.shapes;

import java.util.Vector;

class Segment{
	
	public int x0, x1;
	
	public boolean equals(Object o){
		Segment s = ((Segment)o);
		if(((x0<s.x0) && (s.x1<x1))   ||
		   ((s.x0>x0) && (s.x0<s.x1)) ||
		   ((s.x0<x0) && (s.x1>x0))) {
			return true;
		}
		return false;
	}
}

public class GraphicFile {

	private Vector<GuiRecord> f;
	
	public GraphicFile(){
		f = new Vector<GuiRecord>();
	}
	
	public void add(GuiRecord r){
		f.add(r);
	}
	
	public void bridge(int i, int j){
		f.get(i).setNext(f.get(j));
	}
	
	public JumpEdge[] computeEdge(){
		for(int i=0; i<f.size(); i++){
			
		}
		return null;
		
	}
}
