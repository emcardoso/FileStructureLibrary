package dataGen;

import java.util.Random;

/**
 * Gera um valor aleatório.
 * 
 * @see Rnum
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 */
public class Rnum implements Rgen<Integer> {
    /** Atributos */
    private Random r;
    private int limit;

    /** Construtor Padrão */
    public Rnum() {
        limit = 107374182;
        r = new Random();
    }

    /** Construtor Padrão */
    public Rnum(int l) {
        limit = l;
        r = new Random();
    }

    /**
     * Função que gera uma número Aleatório
     * 
     * @return Interger
     */
    public Integer gen() {
        int num = r.nextInt(limit);
        return num;
    }
}
