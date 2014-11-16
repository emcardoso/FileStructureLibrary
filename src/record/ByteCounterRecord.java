package record;

import java.io.IOException;

import IO.ReadStream;
import IO.WriteStream;
import field.Field;

public abstract class ByteCounterRecord extends VariableSizeRecord{

	public ByteCounterRecord(Field[] f) {
		super(f);
	}
	
	public void write(WriteStream ws) throws IOException {
        byte buff[] = pack();
        
	}

	
	public void read(ReadStream rs) throws IOException {
	}

}