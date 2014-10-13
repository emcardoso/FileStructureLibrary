package dataGen;

import java.util.Random;

/**
 * Gera uma data aleatória respeitando as restrições de ano bissexto e quantidade
 * de dias em cada mês do ano.
 * 
 * @see Rdata
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 */
public class Rdata implements Rgen<String> {
    /** Atributos */
    private Random g;

    /** Construtor Padrão */
    public Rdata() {
        g = new Random();
    }

    /**
     * Função que gera uma data Aleatória
     * 
     * @return String
     */
    public String gen() {
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
        return dia + "/" + mes + "/" + ano;
    }
}
