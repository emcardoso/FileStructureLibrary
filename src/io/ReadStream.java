package io;

import java.io.IOException;
/**
 * Interface que contém métodos de leitura de arquivos.
 * 
 * @see ReadStream
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface ReadStream {
	/**
     * Método read: é um método de leitura que deve ser implementado pelo programador.
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
	public int read() throws IOException;
	/**
     * Método read: é um método de leitura que deve ser implementado pelo programador.
     * Sua vantagem em relação ao método read anterior � que ele pode ler um vetor de bytes
     * passando o vetor como par�metro.
     * 
     * @ param buffer[]
     * 				: Vetor de bytes
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
    public int read(byte buffer[]) throws IOException;
    /**
     * Método skip: é um método que salta um némero de bytes determinado pelo par�metro.
     * 
     * @param n
     * 			: Número de bytes.
     * 
     * @return Um valor inteiro obtido a partir da leitura do arquivo.
     */
    public void skip(int n) throws IOException;
}