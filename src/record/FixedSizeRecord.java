package record;

import java.io.IOException;
import field.*;
import IO.*;

public abstract class FixedSizeRecord extends AbstractRecord{
	
	protected Field fields[];
	private int size; // Tamanho do registro em Bytes;
	
	public FixedSizeRecord(int size, int numberOfFields){
		this.size = size;
		fields = new Field[numberOfFields];		
	}
	
	public int getSize(){
		return size;
	}
	
	// a serem implementados pelo programador
	public void read(ReadStream rs) throws IOException{
		
		fields = concat(rs);
		unpack(fields);
	}
	
	public void write(WriteStream ws) throws IOException{
	
	}
	
	// falta implementar
	public byte[] pack(){
		return null;
	}
	
	public void unpack(byte b[]){		
	}
	
	public Field[] concat(ReadStream rs) throws IOException{
		byte buffer[] = new byte[128];
		rs.read(buffer);
		unpack(buffer);
		return null;             
	}
}

