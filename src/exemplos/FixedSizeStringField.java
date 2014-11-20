package exemplos;

import field.FixedSizeField;

public class FixedSizeStringField extends FixedSizeField {

	private String str;
	
	public FixedSizeStringField(int size) {
		super(size);
	}
	
	public FixedSizeStringField(int size, String s) {
		super(size);
		str = s;
	}
	
	public byte[] pack() {
		try{
          byte buff[] = new byte[getSize()];
		  byte fonte[] = str.getBytes("ASCII");
		  System.arraycopy(fonte, 0, buff, 0, Math.min(fonte.length,buff.length)); 
		  return buff;
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public void unpack(byte[] b) {
		try{
			  str = new String(b,"ASCII");
	    }catch(Exception e){
				e.printStackTrace();
				System.exit(1);
	    }		
	}
	
	public String getString(){
	   return str;
	}
	
	public void setString(String s){
		str = s;
	}
	
	public String toString(){
	     return str; 
	}

}
