package field;

public interface Record {
	abstract public void write(WriteStream ws);
	abstract public void read(ReadStream rs);
	abstract public Field getField();
	abstract public Field FieldAt(int i);
}
