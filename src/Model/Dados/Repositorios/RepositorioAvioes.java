package Model.Dados.Repositorios;

import Model.Negocio.Aviao;
import Model.Dados.Interfaces.IRepositorioAvioes;
import java.util.ArrayList;

public class RepositorioAvioes implements IRepositorioAvioes {
    private ArrayList<Aviao> avioes;

    RepositorioAvioes() {
        this.avioes = new ArrayList<Aviao>();
    }

    @Override
    public void adicionar(Aviao aviao){
        avioes.add(aviao);
    }

    @Override
    public Aviao consultar(int id){
        for (Aviao aviao: avioes){
            if (aviao.getId() == id){
                return aviao;
            }
        }
        return null;
    }

    @Override
    public void remover(Aviao aviao) {
        avioes.remove(aviao);
    }
}
