package testes;

import dataGen.*;

public class testeGen {

    public static void main(String[] args) {

        Rgen<String> cpf = new Rcpf();
        Rgen<String> nome = new Rtable("nomes_masculinos.txt");
        // Rgen<String> nc = new StrCat<String,String>(nome,cpf,"","cpf:","");
        // Rgen<Integer> nat = new NatNum(5);
        StrCat<String, String> cat = new StrCat<String, String>("", " - ", "");
        // Rgen<Integer> cpf2 = new Unique<Integer>(nat);
        // Rgen<String> cpf2 = new Unique<String>(nc2);
        Compose<String, String, String> comp = new Compose<String, String, String>(
                nome, cpf, cat);

        for (int i = 0; i < 10; i++) {
            System.out.println(comp.gen());
        }
    }
}