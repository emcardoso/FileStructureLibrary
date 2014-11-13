package record;

import java.io.IOException;
import IO.*;
import field.*;

public interface AbstractRecord {
	abstract public void write(WriteStream ws) throws IOException;
	abstract public void read(ReadStream rs) throws IOException;
	abstract public Field getField();
	abstract public Field FieldAt(int i);
	abstract public byte[] pack();
	abstract public void unpack(Field b[]);
}
