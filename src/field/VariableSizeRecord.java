package field;

public interface VariableSizeRecord extends Record{
	public byte[] buffer = new byte[128];
}
