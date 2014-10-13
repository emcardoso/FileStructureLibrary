package testes;

public class Registro {

    private String cpf;
    private String nome;
    private String placa;
    private int vaga;
    private String entrada;
    private String saida;
    private String data;

    public Registro(String cpf, String nome, String placa, int vaga,
            String entrada, String data) {
        this.cpf = cpf;
        this.nome = nome;
        this.placa = placa;
        this.vaga = vaga;
        this.entrada = entrada;
        // this.saida = saida;
        this.data = data;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getPlaca() {
        return placa;
    }

    public int getVaga() {
        return vaga;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSaida() {
        return saida;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Registro [vaga: " + vaga + ", carro: " + placa + ", dono(a): "
                + nome + ", cpf: " + cpf + ", data: " + data + ", entrada: "
                + entrada + "]";
    }
}
