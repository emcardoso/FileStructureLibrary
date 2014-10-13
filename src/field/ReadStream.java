package field;

import java.io.IOException;
/**
 * Essa classe � uma interface que cont�m m�todos de leitura de arquivos.
 * 
 * @see ReadStream
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface ReadStream {
	/**
     * M�todo read: � um m�todo de leitura que deve ser implementado pelo programador.
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
	public int read() throws IOException;
	/**
     * M�todo read: � um m�todo de leitura que deve ser implementado pelo programador.
     * Sua vantagem em rela��o ao m�todo read anterior � que ele pode ler um vetor de bytes
     * passando o vetor como par�metro.
     * 
     * @ param buffer[]
     * 				: Vetor de bytes
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
    public int read(byte buffer[]) throws IOException;
    /**
     * M�todo skip: � um m�todo que salta um n�mero de bytes determinado pelo par�metro.
     * 
     * @param n
     * 			: N�mero de bytes.
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
    public void skip(int n) throws IOException;
}