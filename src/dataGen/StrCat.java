package dataGen;

/**
 * Faz a concatenação de duas Strings.
 * 
 * @see StrCat
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 * @param <B>
 * 			: Gerador aleatório do tipo B.
 * @param <C>
 * 			: Gerador aleatório do tipo C.
 */
public class StrCat<B, C> implements Mixer<String, B, C> {
    private String a;
    private String m;
    private String d;

    /** Construtor Padrão */
    public StrCat(String sa, String sm, String sd) {
        a = sa;
        m = sm;
        d = sd;
    }

    /**
     * Função que une as Strings
     * 
     * @return String
     */
    public String mix(B b, C c) {
        return a + b.toString() + m + c.toString() + d;
    }
}
