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
	public void read(ReadStream rs) throws IOException{
		Field[] fields = new Field[size];
		fields = concat(rs);
		unpack(fields);
	}
	abstract public void write(WriteStream ws) throws IOException;
	
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
