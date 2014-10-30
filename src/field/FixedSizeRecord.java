package field;

public abstract class FixedSizeRecord implements Record{
	private int size;
	
	public FixedSizeRecord(int size){
		this.size = size;
	}
	
	public int getSize(){
		return size;
	}
}
