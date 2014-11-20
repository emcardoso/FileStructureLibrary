package exemplos;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.*;

public class TesteEstacionamento {
    
	private ReadFile entrada;
	private WriteFile saida;
	private Estacionamento r;
	
	private RandomPlaca plc;
	private RandomData dt;
	private RandomTempo t;
	private RandomName nome;
	private int id;
	
    public TesteEstacionamento(){
          id = 0;
          nome = new RandomName(1,3);
          plc = new RandomPlaca();
          dt = new RandomData();
          t = new RandomTempo();
    }
	
	public void makeFile(int nRecords){
		try {
			saida = new WriteFile("Saida.txt");
			for(int i = 0; i < nRecords; i++){
				r = new Estacionamento(id++, plc.gen(),nome.gen(),dt.gen(),t.gen(),t.gen());
			    r.write(saida);
			    System.out.println(r.toString());
			}
			
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void readFile(){
		
		try {
			entrada = new ReadFile("Saida.txt");
			while(!entrada.eof()){
				r = new Estacionamento();
			    r.read(entrada);
			    System.out.println(r.toString()); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		TesteEstacionamento t = new TesteEstacionamento();
		t.makeFile(1000);
		System.out.println(" ---- registros escritos no arquivo   ----- ");
		System.out.println(" ---- Lendo o Arquivo   ----- ");
		t.readFile();
	}
}
