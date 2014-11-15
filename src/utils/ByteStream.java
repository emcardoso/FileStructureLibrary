package utils;

public class ByteStream {
	 
	 private byte b[];
	 private int pos;
	 
	 
	 public ByteStream(byte b[]){
	    this.b = b;
	    pos = 0;
	 }
	 
	 public byte read(){
	     return b[pos++];
	 }
	 
	 public int read(byte v[]){
	     int i;
	     for(i=0; i < Math.min(b.length,v.length); i++){
	         v[i] = b[pos++];
	     }
	     return i;
	 }

	 public void write(byte b){
	    this.b[pos++] = b;
	 }
	 
     public int write(byte v[]){
          int i;
          int l = Math.min(b.length,v.length);
          for(i=0; i < l; i++){
              b[pos++] = v[i];
          }
          return i;
     }
     
     
     public boolean eof(){
        return pos >= b.length;
     }
}
