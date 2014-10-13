package dataGen;

/**
 * Faz a concatena��o de duas Strings.
 * 
 * @see StrCat
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 * @param <B>
 * 			: Gerador aleat�rio do tipo B.
 * @param <C>
 * 			: Gerador aleat�rio do tipo C.
 */
public class StrCat<B, C> implements Mixer<String, B, C> {
    private String a;
    private String m;
    private String d;

    /** Construtor Padr�o */
    public StrCat(String sa, String sm, String sd) {
        a = sa;
        m = sm;
        d = sd;
    }

    /**
     * Fun��o que une as Strings
     * 
     * @return String
     */
    public String mix(B b, C c) {
        return a + b.toString() + m + c.toString() + d;
    }
}
