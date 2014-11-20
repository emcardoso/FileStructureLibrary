package exemplos;

import utils.Convert;
import field.FixedSizeField;

public class Data extends FixedSizeField {

	private int dia;
	private int mes;
	private int ano; 
	
	public Data(int d, int m, int a) {
		super(4);
		dia = d;
		mes = m;
		ano = a;
	}
	
	public Data() {
		super(4);
	}

	
	public byte[] pack() {
		int v = 0;
		int c = (2^16)-1 ;
		v = ((dia << 24)) |
		    ((mes << 16)) |
		    ((ano & 0xFFFF));

		return Convert.intToByte(v,4);
	}
	
	public void setData(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}

	
	public void unpack(byte[] b) {
		int v = Convert.byteToInt(b,4);
		ano = (v & 0xFFFF ); 
		mes = (v >> 16) & 0xFF;
		dia = (v >> 24) & 0xFF;
	}
	
	public String toString(){
	   return "" + dia + "/" + mes + "/" + ano;
	}
	
	public int getDia(){
	    return dia;
	}
	
	public int getMes(){
	    return mes;
	}
	
	public int getAno(){
	    return ano;
	}
	
}
