package exemplos;

import java.util.Random;

import dataGen.Rgen;

public class RandomData implements Rgen<Data> {

	    private Random g;
	    
	    
	    public RandomData() {
	        g = new Random();
	    }

	    /**
	     * Função que gera uma data Aleatória
	     * 
	     * @return String
	     */
	    public Data gen() {
	        int ano = 1960 + g.nextInt(40);
	        int mes = g.nextInt(12);
	        int dia = 1;

	        if (mes == 2 && ano % 400 == 0) {
	            dia = 1 + g.nextInt(27);
	        } else if (mes == 2 && ano % 4 == 0 && ano % 100 != 0) {
	            dia = 1 + g.nextInt(28);
	        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
	            dia = 1 + g.nextInt(30);
	        } else {
	            dia = 1 + g.nextInt(31);
	        }
	        
	        return new Data(dia,mes,ano);
	    }
}
