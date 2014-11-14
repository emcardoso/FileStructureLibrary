package record;

public abstract class VariableSizeRecord extends AbstractRecord{
	public byte[] buffer = new byte[128];
}

