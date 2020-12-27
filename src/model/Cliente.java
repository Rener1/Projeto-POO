package model;

public class Cliente {
    private String nome;
    private int cpf;

    public Cliente(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public void comprarPassagem(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }
}
