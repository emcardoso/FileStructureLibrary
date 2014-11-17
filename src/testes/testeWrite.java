package testes;

import io.*;

import java.io.IOException;

public class testeWrite {

    private static WriteStream out;

	public static void main(String[] args) throws IOException {
    	
    	String caminho = "C:\\Users\\pedro_medeiros\\Documents\\GitHub\\FileStructureLibrary\\src\\dataFiles\\Arquivo.txt";
        String texto = "Arquivo de bytes";
        byte[] dados = texto.getBytes();

        out = new WriteFile(caminho);
        out.write(dados);
    }
}
