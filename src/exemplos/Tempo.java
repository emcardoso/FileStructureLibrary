package exemplos;

import field.FixedSizeField;

public class Tempo extends FixedSizeField{
    
	private byte hm[];

	public Tempo(int h, int m) {
		super(2);
		hm = new byte[2];
        setTempo(h,m);
	}
	
	public Tempo(){
		super(2);
		hm = new byte[2];
	}
	
	public byte[] pack() {
		return hm;
	}

	
	public void unpack(byte[] b) {
	   hm[0] = b[0];
	   hm[1] = b[1];
	}
	
	public String toString(){
	   return "" + hm[0] + "h : " + hm[1] + "m";
	}
	
	public void setTempo(int h, int m){
		hm[0] = (byte)(h % 24);
		hm[1] = (byte)(m % 60);
	}
	
	public int getHora(){
	   return (int)hm[0];
	}
	
	public int getMin(){
	   return (int)hm[1];
	}
}
