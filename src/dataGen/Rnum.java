package dataGen;

import java.util.Random;

/**
 * Gera um valor aleat�rio.
 * 
 * @see Rnum
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 */
public class Rnum implements Rgen<Integer> {
    /** Atributos */
    private Random r;
    private int limit;

    /** Construtor Padr�o */
    public Rnum() {
        limit = 107374182;
        r = new Random();
    }

    /** Construtor Padr�o */
    public Rnum(int l) {
        limit = l;
        r = new Random();
    }

    /**
     * Fun��o que gera uma n�mero Aleat�rio
     * 
     * @return Interger
     */
    public Integer gen() {
        int num = r.nextInt(limit);
        return num;
    }
}
