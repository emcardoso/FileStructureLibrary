package exemplos;

import java.util.Random;

import dataGen.Rgen;

public class RandomTempo implements Rgen<Tempo> {

	    private Random g;
	    private int linha;
	    
	    public RandomTempo() {
	        g = new Random();
	        linha = 0;
	    }

	    /**
	     * Função que gera uma data Aleatória
	     * 
	     * @return String
	     */
	    public Tempo gen() {
	        linha = (linha + g.nextInt(240)) % 1440;
	        int h = (linha / 60) % 24;
	        int m = (linha % 60) % 60;
	        return new Tempo(h,m);
	    }
}

