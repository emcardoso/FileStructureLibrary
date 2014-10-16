package dataGen;

import java.util.ArrayList;

/**
 * Gera um CPF aleatório válido.
 * 
 * @see Rcpf
 * @author Elton M Cardoso, Filipe Mussi, Pedro Medeiros.
 * 
 */
public class Rcpf implements Rgen<String> {
    /** Atributos */
    private ArrayList<Integer> listaAleatoria = new ArrayList<Integer>();
    private ArrayList<Integer> listaNumMultiplicados = null;

    /** Construtor Padrão */
    public Rcpf() {
    }

    /**
     * Fun��o um cpf Aleatório
     * 
     * @return String
     */
    public String gen() {
        // Primeiro executamos os metodos de geracao
        listaAleatoria.clear();
        geraCPFParcial();
        geraPrimeiroDigito();
        geraSegundoDigito();
        String texto = "";
        /*
         * Aqui vamos concatenar todos os valores da lista em uma string. Por
         * que isso? Porque a formatacao que o ArrayList gera me
         * impossibilitaria de usar a mascara, pois junto com os numeros gerados
         * ele tambem gera caracteres especias. Ex.: a sa�da de uma lista de
         * inteiros (de 1 a 5) seria essa: [1 , 2 , 3 , 4 , 5] Dessa forma o
         * sistema geraria a excecao ParseException
         */
        int cont = 0;
        for (int item : listaAleatoria) {
            texto += item;
            if (cont == 2 || cont == 5) {
                texto += ".";
            } else if (cont == 8) {
                texto += "-";
            }
            cont++;
        }
        return texto;
    }

    /**
     * Metodo para geracao de um numero aleatorio entre 0 e 9
     * 
     * @return
     */
    public int geraNumAleatorio() {
        // Note que foi preciso fazer um cast para int, ja que Math.random()
        // retorna um double
        int numero = (int) (Math.random() * 10);

        return numero;
    }

    /**
     * Método para geração de parte do nosso CPF (aqui geramos apenas os 9
     * primeiros digitos)
     * 
     * @return
     */
    public ArrayList<Integer> geraCPFParcial() {
        for (int i = 0; i < 9; i++) {
            listaAleatoria.add(geraNumAleatorio());
        }
        return listaAleatoria;
    }

    /**
     * Método para geração do primeiro digito verificador (para isso nos
     * baseamos nos 9 digitos aleatorios gerados anteriormente)
     * 
     * @return
     * */
    public ArrayList<Integer> geraPrimeiroDigito() {
        listaNumMultiplicados = new ArrayList<Integer>();
        int primeiroDigito;
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 10;
        // Para cada item na lista multiplicamos seu valor pelo seu peso
        for (int item : listaAleatoria) {
            listaNumMultiplicados.add(item * peso);
            peso--;
        }
        // Agora somamos todos os itens que foram multiplicados
        for (int item : listaNumMultiplicados) {
            totalSomatoria += item;
        }
        restoDivisao = (totalSomatoria % 11);
        // Se o resto da divisao for menor que 2 o primeiro digito sera 0, senao
        // subtraimos o numero 11 pelo resto da divisao
        if (restoDivisao < 2) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - restoDivisao;
        }
        // Apos gerar o primeiro digito o adicionamos a lista
        listaAleatoria.add(primeiroDigito);
        return listaAleatoria;
    }

    /**
     * Método para geração do segundo digito verificador (para isso nos baseamos
     * nos 9 digitos aleatorios + o primeiro digito verificador)
     * 
     * @return
     */
    public ArrayList<Integer> geraSegundoDigito() {
        listaNumMultiplicados = new ArrayList<Integer>();
        int segundoDigito;
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 11;
        // Para cada item na lista multiplicamos seu valor pelo seu peso
        // (observe que com o aumento da lista o peso tambem aumenta)
        for (int item : listaAleatoria) {
            listaNumMultiplicados.add(item * peso);
            peso--;
        }
        // Agora somamos todos os itens que foram multiplicados
        for (int item : listaNumMultiplicados) {
            totalSomatoria += item;
        }
        restoDivisao = (totalSomatoria % 11);
        // Se o resto da divisao for menor que 2 o segundo digito sera 0, senao
        // subtraimos o numero 11 pelo resto da divisao
        if (restoDivisao < 2) {
            segundoDigito = 0;
        } else {
            segundoDigito = 11 - restoDivisao;
        }
        // Apos gerar o segundo digito o adicionamos a lista
        listaAleatoria.add(segundoDigito);
        return listaAleatoria;
    }
}