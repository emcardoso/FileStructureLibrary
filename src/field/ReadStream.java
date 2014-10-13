package field;

import java.io.IOException;
/**
 * Essa classe é uma interface que contém métodos de leitura de arquivos.
 * 
 * @see ReadStream
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface ReadStream {
	/**
     * Método read: É um método de leitura que deve ser implementado pelo programador.
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
	public int read() throws IOException;
	/**
     * Método read: É um método de leitura que deve ser implementado pelo programador.
     * Sua vantagem em relação ao método read anterior é que ele pode ler um vetor de bytes
     * passando o vetor como parâmetro.
     * 
     * @ param buffer[]
     * 				: Vetor de bytes
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
    public int read(byte buffer[]) throws IOException;
    /**
     * Método skip: É um método que salta um número de bytes determinado pelo parâmetro.
     * 
     * @param n
     * 			: Número de bytes.
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
    public void skip(int n) throws IOException;
}