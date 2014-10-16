package field;

import java.io.IOException;
/**
 * Classe composta por métodos de leitura e escrita de campos de tamanho variável com
 * contador de tamanho.
 * 
 * @see ByteCountField
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public abstract class ByteCountField implements VariableSizeField {

    private long fieldLength; // valor do contador
    private int counterSize; // Número de bytes usado no contador (0-255)

    public long getFieldLength() {
        return fieldLength;
    }
    
    protected void setCounter(int counterSize){
    	this.counterSize = counterSize;
    }
    /**
     * Método read: Lê uma quantidade de bytes determinada por counterSize.
     *
     * @param rs
     *          : Arquivo para leitura.
     * 
     * @return Vazio.
     */   
    public void read(ReadStream rs) throws IOException {
        byte b[] = new byte[counterSize];
        rs.read(b);
        if (counterSize <= 2) {
        	fieldLength = Convert.byteToShort(b, counterSize);
        } else if (counterSize > 2 && counterSize <= 4) {
        	fieldLength = Convert.byteToInt(b, counterSize);
        } else if(counterSize > 4){
        	fieldLength = Convert.byteToLong(b, counterSize);
        }
        byte[] buffer = new byte[(int)fieldLength];
        rs.read(buffer);
        unpack(buffer);
    }
    /**
     * Método write: Escreve uma quantidade de bytes determinada por counterSize.
     *
     * @param ws
     *          : Arquivo para escrita.
     * 
     * @return Vazio.
     */  
    // função que escreve um campo de tamanho variável no arquivo de bytes
    public void write(WriteStream ws) throws IOException {
        byte[] buffer = pack(); // transforma o campo em um vetor de byte

        // escreve o tamanho do campo
        if (counterSize < 2) {
            short tam = (short) buffer.length; // recebe o tamanho do
            ws.write(Convert.shortToByte(tam, counterSize));
        } else if (counterSize >= 2 && counterSize < 4) {
            int tam = (int) buffer.length; // recebe o tamanho do
            ws.write(Convert.intToByte(tam, counterSize));
        } else {
            long tam = (long) buffer.length; // recebe o tamanho do
            ws.write(Convert.longToByte(tam, counterSize));
        }
        ws.write(buffer); // escreve o campo no arquivo
    }
}