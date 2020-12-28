package model;

public class Passagem {
    private Cliente proprietario;
    private int id;
    private Voo voo;
    private int classe;
    private int assento;
    private double bagagem;
    private double preco;
    private boolean valida = false;

    Passagem(Cliente cliente,int id,Voo voo,int classe,double bagagem){
        this.proprietario = cliente;
        this.id = id;
        this.voo = voo;
        this.classe = classe;
        this.bagagem = bagagem;
        this.preco = calcularPreco();
    }

    public void validar(){
        valida = true;
        voo.ocuparVaga(classe);
    }

    private double calcularPreco(){
        double preco;
        preco = 80;
        preco += voo.getDistancia() * 0.02;
        preco += (bagagem -10) * 2;
        preco *= (classe +1);
        return preco;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public Voo getVoo() {
        return voo;
    }

    public int getClasse() {
        return classe;
    }

    public int getAssento() {
        return assento;
    }

    public double getBagagem() {
        return bagagem;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isValida() {
        return valida;
    }
}