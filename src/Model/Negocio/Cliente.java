package Model.Negocio;

import Model.Negocio.Exceptions.ClasseLotadaException;
import Model.Dados.Repositorios.RepositorioClientes;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private final String cpf;
    private int idPassagem = -1;
    private Passagem passagemSelecionada;
    private ArrayList<Passagem> minhasPassagens;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.minhasPassagens = new ArrayList<>();
        RepositorioClientes.adicionar(this);
    }

    public void comprarPassagem(int bagagem){
        if (passagemSelecionada != null) {
            passagemSelecionada.setBagagem(bagagem);
            passagemSelecionada.validar();
            minhasPassagens.add(passagemSelecionada);
            passagemSelecionada = null;
        }
    }

    public void verPassagem(Voo voo,int classe) {
        try {
            passagemSelecionada = voo.gerarPassagem(this,classe);
        } catch (ClasseLotadaException e) {
            System.out.println(e.getMessage());
        }
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
