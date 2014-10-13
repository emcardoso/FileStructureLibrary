package field;

import java.io.IOException;
/**
 * Essa classe � uma interface que cont�m m�todos de escrita em arquivos.
 * 
 * @see WhiteStream
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface WriteStream {
	/**
     * M�todo write: � um m�todo de escrita que deve ser implementado pelo programador.
     * 
     * @param b
     * 			: Vetor de bytes a serem escritos no arquivo.
     * 
     * @return Vazio.
     */
    public void write(byte b[]) throws IOException;
}
