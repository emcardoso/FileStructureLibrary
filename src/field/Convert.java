package field;
/**
 * Essa classe é composta por funções estáticas que tem como objetivo obter um valor e 
 * serializa-lo ou desserializa-lo. Cada função recebe o valor da variável e
 * o seu tamanho em bytes. Ex.: byteToInt(vetor de bytes, quantidade de bytes);
 * 
 * @see Convert
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public class Convert {
    /**
     * M�todo byteToInt: Converte um vetor de bytes em um valor inteiro.
     *
     * @param b
     *          : Vetor de bytes contendo o valor a ser desserializado.
     * @param size
     *          : N�mero de bytes do vetor de entrada.
     * 
     * @return Um valor de tipo int obtido a partir da desserializa��o do vetor de bytes.
     */
    public static int byteToInt(byte[] b, int size) {
        int value = 0, shift;
        for (int i = 0; i < size; i++) {
            shift = (size - 1 - i) * 8;
            value = value | ((int) ((b[i] & 0xFF)) << shift);
        }
        return value;
    }

    /**
     * M�todo byteToLong: Converte um vetor de bytes em um valor long.
     *
     * @param b
     *          : Vetor de bytes contendo o valor a ser desserializado.
     * @param size
     *          : N�mero de bytes do vetor de entrada.
     * 
     * @return Um valor de tipo long obtido a partir da desserializa��o do vetor de bytes.
     */
    public static long byteToLong(byte[] b, int size) {
        long value = 0;
        int shift;
        for (int i = 0; i < size; i++) {
            shift = (size - 1 - i) * 8;
            value = value | ((long) ((b[i] & 0xFF)) << shift);
        }
        return value;
    }

    /**
     * M�todo byteToShort: Converte um vetor de bytes em um valor short.
     * 
     * @param b
     *          : Vetor de bytes contendo o valor a ser desserializado.
     * @param size
     *          : N�mero de bytes do vetor de entrada.
     *                  
     * @return Um valor de tipo short obtido a partir da desserializa��o do vetor de bytes.
     */
    public static short byteToShort(byte[] b, int size) {
        short value = 0;
        int shift;
        for (int i = 0; i < size; i++) {
            shift = (size - 1 - i) * 8;
            value = (short) (value | ((short) ((b[i] & 0xFF)) << shift));
        }
        return value;
    }

    /**
     * M�todo intToByte: Convete de um valor inteiro em um vetor de bytes.
     *
     * @param num
     *            : Um valor do tipo int.
     * @param size
     *            : N�mero de bytes do vetor de sa�da.
     *   
     * @return Um vetor de bytes obtido a partir da serializa��o do valor do inteiro.
     */
    public static byte[] intToByte(int num, int size) {
        byte[] value = new byte[size];
        int shift;
        for (int i = 0; i < size; i++) {
            shift = (size - 1 - i) * 8;
            value[i] = (byte) ((num >> shift) & 0xFF);
        }
        return value;
    }

    /**
     * M�todo longToByte: Convete de um valor long em um vetor de bytes.
     *
     * @param num
     *            : Um valor do tipo long.
     * @param size
     *            : N�mero de bytes do vetor de sa�da.
     *  
     * @return Um vetor de bytes obtido a partir da serializa��o do valor do long.
     */
    public static byte[] longToByte(long num, int size) {
        byte[] value = new byte[size];
        int shift;
        for (int i = 0; i < size; i++) {
            shift = (size - 1 - i) * 8;
            value[i] = (byte) ((num >> shift) & 0xFF);
        }
        return value;
    }

    /**
     * M�todo shortToByte: Convete de um valor short em um vetor de bytes.
     * 
     * @param num
     *            : Um valor do tipo short.
     * @param size
     *            : N�mero de bytes do vetor de sa�da.
     *            
     * @return Um vetor de bytes obtido a partir da serializa��o do valor do short.
     */
    public static byte[] shortToByte(short num, int size) {
        byte[] value = new byte[size];
        int shift;
        for (int i = 0; i < size; i++) {
            shift = (size - 1 - i) * 8;
            value[i] = (byte) ((num >> shift) & 0xFF);
        }
        return value;
    }
}
