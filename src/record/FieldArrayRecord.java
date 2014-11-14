package record;

import java.io.IOException;
import java.util.LinkedList;
import IO.ReadStream;
import IO.WriteStream;
import field.Field;

public abstract class FieldArrayRecord extends AbstractRecord {

	protected Field fields[];
	
	public FieldArrayRecord(Field[] f){
		   fields = f;
	}
		
	
	public void write(WriteStream ws) throws IOException {
		for(int i = 0; i < fields.length; i++){
		    fields[i].write(ws);
		}
	}

	
	public void read(ReadStream rs) throws IOException {
		for(int i = 0; i < fields.length; i++){
		    fields[i].read(rs);
		}
	}
	
	public Field fieldAt(int i) {
		return fields[i];
	}

	public byte[] pack() {
		byte buff[], aux[];
		int count = 0;
		LinkedList< byte[] > bp = new LinkedList<byte[]>();
		
		for(int i = 0; i < fields.length; i++){
		    buff = fields[i].pack();
		    count += buff.length;
		    bp.add(buff);
		}
		buff = new byte[count];
		while(!bp.isEmpty()){
		    aux = bp.removeFirst();
			System.arraycopy(aux,0, buff, 0, aux.length);
		}
		return buff;
	}

	
	public void unpack(byte b[]) {
		

	}

}
