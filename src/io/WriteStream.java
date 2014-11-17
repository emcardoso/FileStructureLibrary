package io;

import java.io.IOException;
/**
 * Interface que contém métodos de escrita em arquivos.
 * 
 * @see WhiteStream
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public interface WriteStream {
	/**
     * Método write: é um método de escrita que deve ser implementado pelo programador.
     * 
     * @param b
     * 			: Vetor de bytes a serem escritos no arquivo.
     * 
     * @return Vazio.
     */
    public void write(byte b[]) throws IOException;
}
