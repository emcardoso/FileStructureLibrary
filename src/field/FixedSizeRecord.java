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
	
	public void read(ReadStream rs) throws IOException{
        	for(int i=0;i<size;i++){
        	int tam = rs.read();
        	
        }
    }
}
