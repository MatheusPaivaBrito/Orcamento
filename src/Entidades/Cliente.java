package Entidades;

public class Cliente extends Documento {
    private String endereco;

    public Cliente(String nome, String endereco) {
        super(nome);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
