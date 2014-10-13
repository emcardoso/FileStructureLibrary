package dataGen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Gerador simples baseado em tabela. A tabela é lida de um arquivo em formato
 * txt. Cada linha do arquivo é considerado como um item da tabela. O arquivo é
 * completamente carrefago no momento no momento da construção do objeto.
 * 
 * @see Rtable
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * @since 21/08/2014
 */
public class Rtable implements Rgen<String> {

    private Random g;
    private List<String> lista;

    /**
     * Construtor.
     * 
     * @param caminho
     *            : Uma string que informa o caminho do arquivo a ser usado como
     *            tabela de dados.
     * 
     */

    public Rtable(String caminho) {
        lista = new ArrayList<String>();
        g = new Random();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File(
                    caminho)));
            lista.clear();
            while (bf.ready()) {
                String linha = bf.readLine();
                lista.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @return Retorna uma string selecioanda aleatoriamente da tabela
     *         carregada.
     */
    public String gen() {
        return lista.get(g.nextInt(lista.size()));
    }
}