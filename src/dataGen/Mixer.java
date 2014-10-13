package dataGen;
/**
 * Interface composta por um m�todo p�blico que tem como objetivo pegar 
 * dois geradores (de tipos diferentes ou iguais) e criar um objeto composto.
 * 
 * @see Mixer
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * @param <A>
 * 			: Gen�rico retornado. 
 * @param <B>
 * 			: Gerador do tipo B.
 * @param <C>
 * 			: Gerador do tipo C.
 */
public interface Mixer<A, B, C> {
    /**
     * M�todo mix: � o m�todo que cria o objeto composto.
     *
     * @param b
     *          : Gerador do tipo B.
     * @param c
     *          : Gerador do tipo c.
     * 
     * @return Composi��o dos dois geradores.
     */
    public A mix(B b, C c);
}
