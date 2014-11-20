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
	private int id;
	
    public TesteEstacionamento(){
          id = 0;
          plc = new RandomPlaca();
          dt = new RandomData();
          t = new RandomTempo();
    }
	
	public void makeFile(int nRecords){
		try {
			saida = new WriteFile("Saida.txt");
			for(int i = 0; i < nRecords; i++){
				r = new Estacionamento(id++, plc.gen(),"Ana Maria",dt.gen(),t.gen(),t.gen());
			    r.write(saida);
			    //System.out.println(r.toString());
			}
			
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void readFile(){
		boolean eof = false;
		try {
			entrada = new ReadFile("Saida.txt");
			while(!eof){
				r = new Estacionamento();
			    r.read(entrada);
			    System.out.println(r.toString()); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			eof = true;
		}
	}
	
	public static void main(String args[]){
		TesteEstacionamento t = new TesteEstacionamento();
		t.makeFile(10);
		t.readFile();
	}
}
