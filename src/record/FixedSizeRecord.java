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


	public void read(ReadStream rs) throws IOException{
		for(int i = 0; i < fields.length; i++){
		    fields[i].read(rs);
		}
	}
	
	public void write(WriteStream ws) throws IOException{
		for(int i = 0; i < fields.length; i++){
		    fields[i].write(ws);
		}
	}


	public byte[] pack(){
		return null;
	}
	
	public void unpack(byte b[]){		
	}
}

