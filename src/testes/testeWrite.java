package testes;

import java.io.IOException;

import field.*;


public class testeWrite {

    private static WriteStream out;

	public static void main(String[] args) throws IOException {
    	
    	String caminho = "Arquivo.txt";
        String texto = "Arquivo de bytes";
        byte[] dados = texto.getBytes();

        out = new WriteFile(caminho);
        out.write(dados);
    }
}
