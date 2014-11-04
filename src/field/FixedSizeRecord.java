package field;

import java.io.IOException;


public abstract class FixedSizeRecord implements Record{
	private int size;
	
	public FixedSizeRecord(int size){
		this.size = size;
	}
	
	public int getSize(){
		return size;
	}
	
	// a serem implementados pelo programador
	abstract public void read(ReadStream rs) throws IOException;
	abstract public void write(WriteStream ws) throws IOException;
	
	// falta implementar
	public byte[] pack(){
		return null;
	}
	public void unpack(byte b[]){		
	}
}
