package testes;

import dataGen.*;

public class testaUnique {

    public static void main(String[] args) {
        testeRegistro reg;
        Rgen<String> cpf = new Unique<String>(new Rcpf());
        Rgen<String> nome = new Unique<String>(
                new Rtable("nomes_femininos.txt"));
        Rgen<Integer> vaga = new Unique<Integer>(new Rnum(100));
        Rgen<String> data = new Unique<String>(new Rdata());

        /*
         * Rgen<Character[]> letras = new Rmult<Character>(new Unique(new
         * Rletter()), 10); Rgen<Integer[]> numeros = new Rmult<Integer>(new
         * Unique(new Rnum(20)), 10); Rgen<String[]> nomes = new
         * Rmult<String>(new Unique(new Rtable("nomes_femininos.txt")), 8);
         * 
         * System.out.println("Lista gerada pelo Rmult: " + letras.gen());
         * System.out.println("Lista gerada pelo Rmult: " + numeros.gen());
         * System.out.println("Lista gerada pelo Rmult: " + nomes.gen());
         */

        for (int i = 0; i < 10; i++) {
            reg = new testeRegistro(cpf.gen(), nome.gen(), "AAA2523", vaga.gen(),
                    "4:20", data.gen());
            System.out.println(reg.toString());
        }
    }
}
