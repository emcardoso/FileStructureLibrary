package exemplos;

import java.util.Random;

import dataGen.*;

public class RandomPlaca implements Rgen<String> {

	    private Random g;
	    private Rletter l;
	    private Rdigit d;
	    
	    public RandomPlaca() {
	        g = new Random();
	        l = new Rletter();
	        d = new Rdigit();
	    }

	    /**
	     * Função que gera uma data Aleatória
	     * 
	     * @return String
	     */
	    public String gen() {
	    	String s = ""; 
	    	for(int i =0; i < 3; i++){
	    		s+= l.gen();
	    	}
	    	s += "-";
	     	for(int i =0; i < 3; i++){
	    		s += d.gen();
	    	}
	     	return s;
	    }
}

