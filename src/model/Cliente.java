package model;

import repositorio.RepositorioCliente;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private final String cpf;
    private int idPassagem = -1;
    private ArrayList<Passagem> minhasPassagens = new ArrayList<>();

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        RepositorioCliente.adicionarCliente(this);
    }

    public boolean comprarPassagem(Passagem passagem){
        if (passagem.validar()) {
            minhasPassagens.add(passagem);
            return true;
        }
        return false;
    }

    public Passagem verPassagem(Voo voo,int classe,double bagagem){
        Passagem passagem = new Passagem(this,nextID(),voo,classe,bagagem);
        return passagem;
    }

    private int nextID(){
        idPassagem++;
        return idPassagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Passagem> getMinhasPassagens(){
        return minhasPassagens;
    }
}
