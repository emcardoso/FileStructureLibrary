package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Extenção da classe WriteStrem que contém métodos de escrita em arquivos.
 * 
 * @see WriteFile
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public class WriteFile extends FileOutputStream implements WriteStream {

    public WriteFile(String path) throws FileNotFoundException {
        super(path);
    }
}