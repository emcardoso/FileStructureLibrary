package field;

import io.*;

import java.io.IOException;

/**
 * Define um campo de tamnho fixo. Essa classe define os métodos read and write
 * supodo um campo de com um determinado tamanho fixo. Os métodos pack e unpak
 * são deixados para serem implementados pelas classes que extensoras. Duas
 * novas funções, cut e fill, foram intruduzidas para lidar com os casos em
 * que os dados a serem escritos são, respectivamente, maiores ou menores que o
 * tamanho do campo.
 * 
 * @see FixedSizeField
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 */

public abstract class FixedSizeField implements Field{

    private int size;

    /**
     * Construtor do campo de tamanho fixo
     * 
     * @param Size
     *            o tamanho, em bytes, do campo.
     * 
     */
    public FixedSizeField(int size) {
        this.size = size;
    }

    /**
     * Método getter para obter o tamanho do campo.
     * 
     * @return o tamanho do campo em bytes.
     */
    public int getSize() {
        return size;
    }

    /**
     * Função de preenchimento do campo. Essa função é chamanda sempre que,
     * ao se escrever o campo, o tamnho do vetor de bytes gerado pelo método
     * pack for menor que o tamnho informado no construtor do campo. O
     * comportamento padrão dessa função é preencher o espaço restante com
     * byte nullo.
     * 
     * @param buffer
     *            O vetor de bytes gerado pelo método pack.
     * @param size
     *            O tamanho pretentendido (infromado no construtor) para o
     *            campo.
     * @return Um vetor de bytes do tamanho esperador do campo, completamente
     *         preenchido.
     */
    public byte[] fill(byte[] buffer, int size) {
        byte b[] = new byte[size];
        int i;
        for (i = 0; i < buffer.length; i++) {
            b[i] = buffer[i];
        }
        for (int k = i; k < b.length; k++) {
            b[k] = 0;
        }
        return b;
    }

    /**
     * Função de corte. Essa função é chamanda sempre que, ao se escrever o
     * campo, o tamnho do vetor de bytes gerado pelo método pack for maior que
     * o tamnho informado no construtor do campo. O comportamento padrão dessa
     * função é truncar o tamanho do vetor, de modo que ele permaneça do
     * tamanho informado.
     * 
     * @param buffer
     *            O vetor de bytes gerado pelo método pack.
     * @param size
     *            O tamanho pretentendido (infromado no construtor) para o
     *            campo.
     * @return Um nove vetor de bytes com tamnho apropriado.
     */
    public byte[] cut(byte[] buffer, int size) {
        byte b[] = new byte[size];
        int i;
        for (i = 0; i < size; i++) {
            b[i] = buffer[i];
        }
        return b;
    }

    /**
     * Método de leitura de dados. Essa classe provê uma simplmes
     * implementação para o método de leitura de dados. Cria-se um buffer do
     * tamanho do campo, em seguida, preenche-se esse buffer com os dados do
     * disco. Em seguida o método unpakc é chamado sobre o buffer previamente
     * carregado.
     * 
     * @param rs
     *            O stream de entrada de onde os dados devem ser lidos.
     */
    public void read(ReadStream rs) throws IOException {
        byte buffer[] = new byte[size];
        rs.read(buffer);
        unpack(buffer);
    }

    /**
     * Método de escrita de dados. Essa classe provê uma simplmes
     * implementação para o método de escrita de dados. Invoca-se o método
     * pack para se obter um buffer de bytes. Verifica-se o tamanho do vetor de
     * bytes obtido a fim de se determinar a necessidade de se chamar a função
     * fill ou a função cut. Em seguida o método write é chamado sobre o
     * buffer previamente carregado.
     * 
     * @param ws
     *            O stream de saída onde os dados devem ser escritos.
     */
    public void write(WriteStream ws) throws IOException {
        byte buffer[] = pack();
        if (buffer.length < size) {
            buffer = fill(buffer, size);
        } else if (buffer.length > size) {
            buffer = cut(buffer, size);

        }
        ws.write(buffer);
    }
}