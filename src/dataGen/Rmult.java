package dataGen;

/**
 * Tem como objetivo definir um gerador de um conjunto n valores
 * randômicos.
 * 
 * @see Rmult
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 */
public class Rmult<A> implements Rgen<A[]> {

    private Rgen<A> g1;
    private int n;

    /**
     * Construtor Padrão:
     * 
     * @param g
     *            : Um gerador de dados randômicos de tipo A
     * @param m
     *            : O número de dados a serem gerados.
     */
    public Rmult(Rgen<A> g, int m) {
        this.g1 = g;
        this.n = m;
    }

    /**
     * Gera um vetor de valores randômicos produzidos a partir do gerador g.
     * 
     * @return Um vetor de n de objetos do tipo A. Para se obter esse vetor o
     *         gerador g1, passado comp parâmetro é chamada n vezes.
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
