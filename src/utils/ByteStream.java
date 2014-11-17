package utils;

import io.ReadStream;
import io.WriteStream;

import java.io.IOException;
import java.io.IOException;

public class ByteStream implements ReadStream, WriteStream{
	 
	/**
	 * Um Stream de bytes para ser utilizado pelos campos. 
	 * O Stream de bytes pode ser lido de qualquer  
	 */
	
	 private byte b[];
	 private int pos;
	 
	 
	 public ByteStream(byte b[]){
	    this.b = b;
	    pos = 0;
	 }
	 
	 public ByteStream(int size){
		    this.b = new byte[size];
		    pos = 0;
     }
	 
	 public int read() throws IOException {
	     return b[pos++];
	 }
	 
	 public int read(byte v[]) throws IOException {
	     int i;
	     for(i=0; i < Math.min(b.length,v.length); i++){
	         v[i] = b[pos++];
	     }
	     return i;
	 }

	 public void write(byte b)throws IOException {
	    if(pos >= this.b.length){
	        grow();
	    }
		this.b[pos++] = b;
	 }
	 
     public void write(byte v[]) throws IOException {
          int i;
          int l = Math.min(b.length,v.length);
  	      if(pos >= this.b.length){
	          grow();
	      }
          for(i=0; i < l; i++){
              b[pos++] = v[i];
          }
     }
     
     
     public boolean eof(){
        return pos >= b.length;
     }
     
     private void grow(){
        byte v[] = new byte[2*b.length];
        for(int i = 0; i < b.length; i++){
           v[i] = b[i];
        }
        b= v;
     }

	@Override
	public void skip(int n) throws IOException {
		pos += n;
	}
	
	public byte[] getBytes(){
	    byte out[] = new byte[pos];
		for(int i =0; i < pos; i++){
		    out[i] = b[i];
		}
	    return out;
	}
	
	public void reset(){
	   pos = 0;
	}
}
