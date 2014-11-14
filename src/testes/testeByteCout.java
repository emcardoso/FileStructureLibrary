package testes;

import java.io.IOException;
import field.*;
import IO.*;

public class testeByteCout {
	public static void main(String arg[]) throws IOException{
		ByteCount count = new ByteCount();
			
		String caminho = "C:\\Users\\pedro_medeiros\\Documents\\GitHub\\FileStructureLibrary\\src\\dataFiles\\ByteCout.dat";
		WriteStream out = new WriteFile(caminho);
		ReadStream in = new ReadFile(caminho);
		
		String texto = "Funfou!! hehe";

		count.setDate(texto);
		
		count.write(out);
		
		count.read(in);
		System.out.println(count);
		System.out.println(count.getFieldLength());
		
	}
}

class ByteCount extends ByteCountField{
	
	byte[] date;
	
	public ByteCount(){
		setCounter(4);
	}
	public void setDate(String texto){
		this.date = texto.getBytes(); 
	}
	
	public byte[] pack() {
		return date;
	}

	public void unpack(byte[] b) {
		date = b;
	}
	
	public String toString(){
		return new String(date);
	}
}
