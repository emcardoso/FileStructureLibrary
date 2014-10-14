package dataGen;

/**
 * Tem como objetivo combinar dois geradores de valores randômicos,
 * por meio de uma função mix. A função é recebida como parâmetro por meior de
 * um objeto que implementa a interface mixer. Essa interface define apenas uma
 * função A mix(B,C).
 * 
 * @see Compose
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public class Compose<A, B, C> {

    private Rgen<B> b;
    private Rgen<C> c;
    private Mixer<A, B, C> m;

    /**
     * Construtor padrão.
     * 
     * @param b
     *            : Um gerador de valores randômicos de tipo B.
     * @param c
     *            : Um gerador de valores randômicos de tipo C.
     * @param m
     *            : Um mixer de tipos A,B e C.
     */
    public Compose(Rgen<B> b, Rgen<C> c, Mixer<A, B, C> m) {
        this.b = b;
        this.c = c;
        this.m = m;
    }

    /**
     * Método gen: Aplica a função mix aos valore gerados pelos geradores de
     * tipo B e C respectivamente, retornando o resultado o resultado da função
     * mix de tipo A.
     * 
     * @return Um valor de tipo A obtido a partir da combinação de dois valores
     */
    public A gen() {
        return m.mix(b.gen(), c.gen());
    }
}