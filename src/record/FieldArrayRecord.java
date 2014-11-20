package record;

import io.ReadStream;
import io.WriteStream;

import java.io.IOException;

import field.Field;
import utils.ByteStream;

/**
 * Implemnta um registro por meio de um vetor de campos. 
 * Essa é uma impelementação simples, mas que não provê nenhum
 * mecanismo de teste para determinar se os campos obedecem ou não
 * qualquer restrição em relação ao tamanho do registro.
 * Essa classe tem como objetivo servir de plataforma para implementação
 * de outros tipos de registro, provendo implementações padrão para 
 * algumas das funções de registro.
 *
 */
public abstract class FieldArrayRecord extends AbstractRecord {

	/**
	 * Campo protegiso fileds[] é um vetor de campos.
	 */
	protected Field fields[];
	
	public FieldArrayRecord(Field[] f){
		   fields = f;
	}
	
	public FieldArrayRecord(int numberOfFields){
	    fields = new Field[numberOfFields];
	}
		
	
	public void write(WriteStream ws) throws IOException {
		for(int i = 0; i < fields.length; i++){
		    fields[i].write(ws);
		}
	}

	
	public void read(ReadStream rs) throws IOException {
		for(int i = 0; i < fields.length; i++){
		    fields[i].read(rs);
		}
	}
	
	public Field fieldAt(int i) {
		return fields[i];
	}

	public byte[] pack() {
		ByteStream bs = new ByteStream(512); 
		try{
			for(int i = 0; i < fields.length; i++ ){
	             fields[i].write(bs);
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("IOException cautch when trying to pack record. ");
		}
		return bs.getBytes();
	}

	public void unpack(byte b[]) {
		ByteStream bs = new ByteStream(b); 
		try{
			for(int i = 0; i < fields.length; i++ ){
	             fields[i].read(bs);
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("IOException cautch when trying to unpack record. ");
		}
		
	}

}
