package exemplos;

import field.*;
import record.*;



public class Estacionamento extends FixedSizeRecord{
    
	public Estacionamento() {
		super(128, 6);
		fields[0] = new Inteiro();   //ID
		fields[1] = new FixedSizeStringField(8);   // Placa
		fields[2] = new FixedSizeStringField(108); // Nome
		fields[3] = new Data(); // Data de entrada
		fields[4] = new Tempo(); // Hora de entrada;
		fields[5] = new Tempo(); // Hora de Saida;
	}
	
	public Estacionamento(int id, String placa, String nome, Data entrada, 
			Tempo tEntrada, Tempo tSaida) {
		super(128, 6);
		fields[0] = new Inteiro(id);   //ID
		fields[1] = new FixedSizeStringField(8, placa);   // Placa
		fields[2] = new FixedSizeStringField(108, nome); // Nome
		fields[3] = entrada; // Data de entrada
		fields[4] = tEntrada; // Hora de entrada;
		fields[5] = tSaida; // Hora de Saida;
	}


	public byte[] fill(byte[] v, int size) {
		byte b[] = new byte[size];
		for(int i = 0; i < v.length; i++){
		    b[i] = v[i];
		}
		return b;
	}

	public byte[] cut(byte[] v, int size) {
		throw new RuntimeException("Tamnho do registro excedido !");
	}	
	
	public String toString(){
	   String s = "";
	   for(int i =0; i < fields.length; i++){
		   s += fields[i].toString() + "\n";		   
	   }
	   return s;
	}
	
}
