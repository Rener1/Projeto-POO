package exceptions;

import model.Voo;

public class ClasseLotadaException extends Exception{
    private int classe;
    private Voo voo;

    public ClasseLotadaException(Voo voo, int classe) {
        super("Esta classe do voo encontra-se lotada!");
        this.classe = classe;
        this.voo = voo;
    }

    public int getClasse() {
        return classe;
    }

    public Voo getVoo() {
        return voo;
    }
}
