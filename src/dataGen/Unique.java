package dataGen;

import java.util.TreeMap;

/**
 * Essa classe tem como objetivo tornar um gerador de valores randômicos
 * qualquer em um gerador que nunca gerar o mesmo valor mais de uma vez.
 * 
 * <p>
 * <b>ATENÇÂO </b>: Para evitar a repetição de valores essa classe utiliza uma
 * árvore Vermelho e preta para memorizar cada valor gerado, resultanto em
 * impcatos no consumo de memória e no tempo de execução.
 * </p>
 * <p>
 * Note que o método gen, dessa classe, irá invocar o método gen do gerado
 * passado como argumento, até que um valor diferente dos valores aramazenados
 * na árovre seja produzido. Por essa razão o uso de um objeto dessa classe pode
 * fazer com que o programa entre em loop.
 * </p>
 * .
 * 
 * @see Unique
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 */
public class Unique<A> implements Rgen<A> {
    /** Atributos */
    private TreeMap<A, Integer> arv;
    private Rgen<A> g1;
    private A key;

    /**
     * Construtor Padrão a partir de um gerador g. Esse construtor seta o
     * gerador de dados a ser tornado único e inicaliza a árvore balançada.
     * 
     * @param g
     *            Um gerador de dados de tipo A.
     * 
     */
    public Unique(Rgen<A> g) {
        g1 = g;
        arv = new TreeMap<A, Integer>();
    }

    /**
     * Gera um valor randômico único. O valor gerado é armazenado em um árovre
     * balanceada, para consulta futura. Se o valor gerado já estiver presente
     * na árovre, o método de gen do gerador g1 é invocado novamente.
     * 
     * @return Valor randômico do tipo A
     */
    public A gen() {
        key = g1.gen();

        while (arv.containsKey(key)) {
            key = g1.gen();
        }
        arv.put(key, null);
        return key;
    }
}
