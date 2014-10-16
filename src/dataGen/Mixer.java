package dataGen;
/**
 * Interface composta por um método público que tem como objetivo pegar 
 * dois geradores (de tipos diferentes ou iguais) e criar um objeto composto.
 * 
 * @see Mixer
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * @param <A>
 * 			: Genérico retornado. 
 * @param <B>
 * 			: Gerador do tipo B.
 * @param <C>
 * 			: Gerador do tipo C.
 */
public interface Mixer<A, B, C> {
    /**
     * Método mix: é o método que cria o objeto composto.
     *
     * @param b
     *          : Gerador do tipo B.
     * @param c
     *          : Gerador do tipo c.
     * 
     * @return Composição dos dois geradores.
     */
    public A mix(B b, C c);
}
