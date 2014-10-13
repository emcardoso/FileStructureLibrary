package dataGen;

/**
 * Tem como objetivo combinar dois geradores de valores rand�micos,
 * por meio de uma fun��o mix. A fun��o � recebida como par�metro por meior de
 * um objeto que implementa a interface mixer. Essa interface define apenas uma
 * fun��o A mix(B,C).
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
     * Construtor padr�o.
     * 
     * @param b
     *            : Um gerador de valores rand�micos de tipo B.
     * @param c
     *            : Um gerador de valores rand�micos de tipo C.
     * @param m
     *            : Um mixer de tipos A,B e C.
     */
    public Compose(Rgen<B> b, Rgen<C> c, Mixer<A, B, C> m) {
        this.b = b;
        this.c = c;
        this.m = m;
    }

    /**
     * M�todo gen: Aplica a fun��o mix aos valore gerados pelos geradores de
     * tipo B e C respectivamente, retornando o resultado o resultado da fun��o
     * mix de tipo A.
     * 
     * @return Um valor de tipo A obtido a partir da combina��o de dois valores
     */
    public A gen() {
        return m.mix(b.gen(), c.gen());
    }
}