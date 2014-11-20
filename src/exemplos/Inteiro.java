package exemplos;

import field.FixedSizeField;
import utils.Convert;

public class Inteiro extends FixedSizeField{

	private int x;
	 
	public Inteiro(int x) {
		super(4);   // tamanho do campo 4 bytes;
		this.x = x;
	}
	
	public Inteiro() {
		super(4);   // tamanho do campo 4 bytes;
		this.x = 0;
	}


	public byte[] pack() {
		return Convert.intToByte(x, getSize());
	}

	public void unpack(byte[] b) {
		x = Convert.byteToInt(b, getSize());		
	}
	
	public void setInt(int x){
		this.x = x;
	}
	public int getInt(){
		return x;
	}
	
	public String toString(){
		return ""+x;
	}
     
}
