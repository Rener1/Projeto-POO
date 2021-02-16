package Model.Dados.Repositorios;

import Model.Negocio.Aeroporto;
import Model.Dados.Interfaces.IRepositorioAeroportos;
import java.util.ArrayList;

public class RepositorioAeroportos implements IRepositorioAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    RepositorioAeroportos() {
        this.aeroportos = new ArrayList<Aeroporto>();
    }

    @Override
    public void adicionar(Aeroporto aeroporto){
        aeroportos.add(aeroporto);
    }

    @Override
    public Aeroporto consultar(int id) {
        for (Aeroporto aeroporto: aeroportos) {
            if (aeroporto.getId() == id) {
                return aeroporto;
            }
        }
        return null;
    }

    @Override
    public void remover(Aeroporto aeroporto) {
        aeroportos.remove(aeroporto);
    }
}
