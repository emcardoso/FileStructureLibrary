package record;

public interface VariableSizeRecord extends AbstractRecord{
	public byte[] buffer = new byte[128];
}

