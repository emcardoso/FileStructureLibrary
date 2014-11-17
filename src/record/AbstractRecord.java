package record;

import io.*;
import java.io.IOException;

import field.*;

public abstract class AbstractRecord {
	abstract public void write(WriteStream ws) throws IOException;
	abstract public void read(ReadStream rs) throws IOException;
	abstract public Field fieldAt(int i);
	abstract public byte[] pack();
	abstract public void unpack(byte b[]);
}
