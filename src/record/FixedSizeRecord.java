package record;

import io.*;

import java.io.IOException;

import field.*;

public abstract class FixedSizeRecord extends FieldArrayRecord{
	
	private int size; // Tamanho do registro em Bytes;
	
	
	public FixedSizeRecord(int size, Field[] f){
		super(f);
		this.size = size;		
	}
	
	public FixedSizeRecord(int size, int numberOfFields){
	    super(numberOfFields);
	    this.size = size;	
	}
	
	public int getSize(){
		return size;
	}
    
	public abstract byte[] fill(byte v[], int size);
	public abstract byte[] cut(byte v[], int size);
	
	public void read(ReadStream rs) throws IOException{
		byte buff[] = new byte[size];
		rs.read(buff);
		unpack(buff);
	}
	
	public void write(WriteStream ws) throws IOException{
		byte buff[] = pack();
        if(buff.length > size){
            buff = cut(buff, size);
        }
        else if(buff.length < size){
        	buff = fill(buff,size);
        }
		ws.write(buff);
	}

}

