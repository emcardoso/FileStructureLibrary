package dataGen;

import java.util.Random;

/**
 * Gera uma string aleatória a partir de strings obtidas de arquivo.txt
 * 
 * @see Rletter
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 */
public class Rletter implements Rgen<Character> {
    /** Atributos */
    private Random l;

    /** Construtor Padrão */
    public Rletter() {
        l = new Random();
    }

    /**
     * Função que gera uma letra do alfabeto
     * 
     * @return Caracter
     */
    public Character gen() {
        char letter = (char) (65 + l.nextInt(26));
        return letter;
    }
}