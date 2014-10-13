package dataGen;

import java.util.Random;

/**
 * Gera uma string aleat�ria a partir de strings obtidas de arquivo.txt
 * 
 * @see Rletter
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 */
public class Rletter implements Rgen<Character> {
    /** Atributos */
    private Random l;

    /** Construtor Padr�o */
    public Rletter() {
        l = new Random();
    }

    /**
     * Fun��o que gera uma letra do alfabeto
     * 
     * @return Caracter
     */
    public Character gen() {
        char letter = (char) (65 + l.nextInt(26));
        return letter;
    }
}