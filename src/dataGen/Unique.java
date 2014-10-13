package dataGen;

import java.util.TreeMap;

/**
 * Essa classe tem como objetivo tornar um gerador de valores rand�micos
 * qualquer em um gerador que nunca gerar o mesmo valor mais de uma vez.
 * 
 * <p>
 * <b>ATEN��O </b>: Para evitar a repeti��o de valores essa classe utiliza uma
 * �rvore Vermelho e preta para memorizar cada valor gerado, resultanto em
 * impcatos no consumo de mem�ria e no tempo de execu��o.
 * </p>
 * <p>
 * Note que o m�todo gen, dessa classe, ir� invocar o m�todo gen do gerado
 * passado como argumento, at� que um valor diferente dos valores aramazenados
 * na �rovre seja produzido. Por essa raz�o o uso de um objeto dessa classe pode
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
     * Construtor Padr�o a partir de um gerador g. Esse construtor seta o
     * gerador de dados a ser tornado �nico e inicaliza a �rvore balan�ada.
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
     * Gera um valor rand�mico �nico. O valor gerado � armazenado em um �rovre
     * balanceada, para consulta futura. Se o valor gerado j� estiver presente
     * na �rovre, o m�todo de gen do gerador g1 � invocado novamente.
     * 
     * @return Valor rand�mico do tipo A
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
