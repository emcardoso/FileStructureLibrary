package dataGen;

/**
 * Tem como objetivo definir um gerador de um conjunto n valores
 * rand�micos.
 * 
 * @see Rmult
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 */
public class Rmult<A> implements Rgen<A[]> {

    private Rgen<A> g1;
    private int n;

    /**
     * Construtor Padr�o:
     * 
     * @param g
     *            : Um gerador de dados rand�micos de tipo A
     * @param m
     *            : O n�mero de dados a serem gerados.
     */
    public Rmult(Rgen<A> g, int m) {
        this.g1 = g;
        this.n = m;
    }

    /**
     * Gera um vetor de valores rand�micos produzidos a partir do gerador g.
     * 
     * @return Um vetor de n de objetos do tipo A. Para se obter esse vetor o
     *         gerador g1, passado comp par�metro � chamada n vezes.
     * 
     */
    
	public A[] gen() {
		@SuppressWarnings("unchecked")
		A[] objs = (A[]) new Object[n];
        for (int i = 0; i < n; i++) {
            objs[i] = g1.gen();
        }
        return objs;
    }
}
