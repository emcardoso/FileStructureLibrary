package record;

import io.ReadStream;
import io.WriteStream;

import java.io.IOException;

import utils.Convert;
import field.Field;

public abstract class ByteCounterRecord extends VariableSizeRecord{
    
	private int counterSize;
	
	
	public ByteCounterRecord(Field[] f) {
		super(f);
		counterSize = 4;
	}
	
	public ByteCounterRecord(Field[] f, int counterSize) {
		super(f);
		this.counterSize = counterSize;
	}
	
	public void write(WriteStream ws) throws IOException {
        byte buff[] = pack();
        byte[] counter = Convert.intToByte(buff.length, counterSize);
        ws.write(counter);
        ws.write(buff);
	}

	
	public void read(ReadStream rs) throws IOException {
        byte[] counter = new byte[counterSize];
        rs.read(counter);
        int c = Convert.byteToInt(counter, counterSize);
        byte buff[] = new byte[c];
        rs.read(buff);
	}

}