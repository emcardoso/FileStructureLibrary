package exemplos;

import java.util.Random;

import dataGen.*;

public class RandomName implements Rgen<String>{

	private int min; 
	private int max;
	private Random g;
	 
	private Rtable masc;
	private Rtable fem;
	private Rtable sobre;
	
	public RandomName(int minSobreNome, int maxSobrenome){
	    min = minSobreNome;
	    max = maxSobrenome;
	    masc = new Rtable("src/DataFiles/nomes_masculinos.txt");
	    fem = new Rtable("src/DataFiles/nomes_femininos.txt");
	    sobre = new Rtable("src/DataFiles/sobrenomes.txt");
	    g = new Random();
	}
	
	public String gen() {
		String r = g.nextBoolean() ? masc.gen() : fem.gen();
		int l = min + g.nextInt(max-min+1);
		for(int i = 0; i < l; i++){
			r += " " + sobre.gen();
		}
		return r;
	}
     
}
