package dataGen;

/**
 * Interface Rgen especifica, que deve ser implementada por todo gerador de
 * dados Aleatório.
 * 
 * @see Rgen
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface Rgen<A> {
    /**
     * Método gen(): Deve ser implementado pelo progrador gerando um resultado
     * de tipo genérico A. Chamremos esses resultado de valores randômicos. Note
     * que um valor randômico só pode ser um objeto, já que em Java7 uma
     * variável de tipo não pode ser instanciada para um tipo primitivo.
     * 
     * @return Objeto do tipo A
     */
    public A gen();
}