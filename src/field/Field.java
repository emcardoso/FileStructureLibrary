package field;

import java.io.IOException;

/**
 * Interface Field define as operações básicas de campo. Essa classe define as
 * operações que devem ser implmentadas por qualquer campo. Uma atenção especial
 * deve ser dada a implementação dos métodos read e write que requerem como
 * parâmetros ReadStream e WriteStream respectivamente. A razão para a adoção
 * dessas interfaces, em dterimento das interfaces de java, é impedir que um
 * campo realize operações inesperadas sob o stream de entrada/saída de dados. Se
 * o camo recebesse diretamente um InputStream, seria possível, por exemplo, que
 * o usuário inadivertamente fechasse o stream de entrada de dados e em seguida
 * abrisse um novo arquivo.
 * 
 * @see Field
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 */

public interface Field {

    /**
     * M�todo de leitura de dados. Esse m�todo deve implementar o mecanismo de
     * leitura de dados de um stream de entrada (ReadStream). A raz�o para o uso
     * de ReadStream ao inv�s de InputStream � meramente did�tica, impedindo
     * qualquer modifica��o significante no Stream de entrada, por parte do
     * campo.
     * 
     * @param rs
     *            A entrada de dados de onde deve ser feita a leitura.
     * @throws IOException
     *             Caso ocorra qualquer exce��o de IO durante a leitura dos
     *             dados.
     */
    abstract public void read(ReadStream rs) throws IOException;

    /**
     * M�todo de escrita de dados. Esse m�todo deve implementar o mecanismo de
     * escrita de dados, utilizando o WriteStream. Analogamene ao read, o uso do
     * WriteStream, ao inv�s de InputStream � meramente did�tico.
     * 
     * @param ws
     *            A entrada de dados de onde deve ser feita a leitura.
     * @throws IOException
     *             Caso ocorra qualquer exce��o de IO durante a escrita dos
     *             dados.
     */
    abstract public void write(WriteStream ws) throws IOException;

    /**
     * A fun��o pack converte o campo em um vetor de bytes.
     * 
     * @return Uma representa��o desse campo na forma de um vetor de bytes.
     */
    abstract public byte[] pack();

    /**
     * A fun��o unpack recebe um vetor de bytes e o usa para prencher o campo,
     * convertando a informa��o em representa��o de baixo n�vel em dados.
     * 
     * @param b
     *            um vetor de bytes
     * @return Preenche o campo com os dados do vetor b.
     */
    public abstract void unpack(byte b[]);

}