package field;

import java.io.IOException;

public interface Record {
	abstract public void write(WriteStream ws);
	abstract public void read(ReadStream rs) throws IOException;
	abstract public Field getField();
	abstract public Field FieldAt(int i);
}
