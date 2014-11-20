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
		int c = (2^16) - 1;
		v = (v & (dia << 24)) |
		    (v & (mes << 16)) |
		    (v & (ano & c));
		return Convert.intToByte(v,4);
	}
	
	public void setData(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}

	
	public void unpack(byte[] b) {
		int v = Convert.byteToInt(b,4);
		int c = (0xFFFF);
		ano = (v & c); 
		mes = (v >> 16) & 0xFF;
		mes = (v >> 24) & 0xFF;
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
