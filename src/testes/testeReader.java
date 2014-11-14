package testes;

import java.io.IOException;
import java.util.LinkedList;

import IO.*;

public class testeReader {

    private static ReadFile ler;

	public static void main(String[] args) throws IOException {
        LinkedList<byte[]> list = new LinkedList<byte[]>();
        ler = new ReadFile("C:\\Users\\pedro_medeiros\\Documents\\GitHub\\FileStructureLibrary\\src\\dataFiles\\nomes_masculinos.txt");
        int i = 0, date, achou = 0;
        byte fieldMarker = '\n';
        // ler do arquivo

        date = ler.read();

        while (date != -1) {
            byte[] buffer = new byte[128];
            int c = 1;
            buffer[1] = (byte) date;
            for (i = 2; i <= 127; i++) {
                buffer[i] = (byte) ler.read();
                if (buffer[i] == fieldMarker || buffer[i] == -1) {
                    achou = 1;
                    break;
                }
                c++;
            }
            buffer[0] = (byte) c;
            list.add(buffer);
            date = ler.read();
            if (achou == 1) {
                break;
            }
        }

        for (i = 0; i <= list.size() - 1; i++) {
            System.out.println(unpack(list.get(i)));
        }
    }

    public static char[] unpack(byte[] buffer) {
        int m;
        m = (int) buffer[0];
        char palavra[] = new char[m];
        for (int i = 1; i <= m; i++) {
            palavra[i - 1] = (char) buffer[i];
        }
        return palavra;
    }
}