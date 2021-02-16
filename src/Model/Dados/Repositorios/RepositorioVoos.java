package Model.Dados.Repositorios;

import Model.Dados.Interfaces.IRepositorioVoos;
import Model.Negocio.Voo;
import java.util.ArrayList;

public class RepositorioVoos implements IRepositorioVoos {
    private ArrayList<Voo> voos;

    RepositorioVoos() {
        this.voos = new ArrayList<Voo>();
    }

    @Override
    public void adicionar(Voo voo){
        voos.add(voo);
    }

    @Override
    public Voo consultar(int id){
        for (Voo voo: voos){
            if (voo.getId() == id){
                return voo;
            }
        }
        return null;
    }

    @Override
    public void remover(Voo voo) {
        voos.remove(voo);
    }
}
