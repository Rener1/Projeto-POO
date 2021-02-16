package Model.Negocio;

public class Passagem {
    private Cliente proprietario;
    private int id;
    private Voo voo;
    private int classe;
    private int assento;
    private double bagagem;
    private double preco;
    private boolean valida;

    Passagem(Cliente cliente,Voo voo,int classe) {
        this.proprietario = cliente;
        this.voo = voo;
        this.classe = classe;
        this.preco = voo.getPrecoBase();
    }

    public void validar(){
        valida = true;
        assento = voo.ocuparVaga(this,classe);
    }

    private void calcularPreco(){
        double preco = voo.getPrecoBase();
        preco += (bagagem -10) * 2;
        preco *= (classe +1);
        this.preco = preco;
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

    public void setBagagem(int bagagem) {
        this.bagagem = bagagem;
        calcularPreco();
    }

    public double getPreco() {
        return preco;
    }

    public boolean isValida() {
        return valida;
    }
}
