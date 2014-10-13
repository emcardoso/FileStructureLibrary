package dataGen;

/**
 * Interface Rgen especifica, que deve ser implementada por todo gerador de
 * dados Aleat�rio.
 * 
 * @see Rgen
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface Rgen<A> {
    /**
     * M�todo gen(): Deve ser implementado pelo progrador gerando um resultado
     * de tipo gen�rico A. Chamremos esses resultado de valores rand�micos. Note
     * que um valor rand�mico s� pode ser um objeto, j� que em Java7 uma
     * vari�vel de tipo n�o pode ser instanciada para um tipo primitivo.
     * 
     * @return Objeto do tipo A
     */
    public A gen();
}