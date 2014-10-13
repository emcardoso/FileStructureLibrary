package field;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Essa classe � uma exten��o da classe ReadStream que cont�m m�todos de leitura de arquivos.
 * 
 * @see ReadFile
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 * 
 */
public class ReadFile extends FileInputStream implements ReadStream {

    public ReadFile(String path) throws FileNotFoundException {
        super(path);
    }

    public void skip(int n) throws IOException {
        // TODO Auto-generated method stub
    }
}