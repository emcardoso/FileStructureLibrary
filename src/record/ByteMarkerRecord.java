package record;

import field.Field;

public abstract class ByteMarkerRecord extends VariableSizeRecord{

	private byte mark;
	
	public ByteMarkerRecord(Field[] f, byte mark) {
		super(f);
	    this.mark = mark;	
	}
    
}
