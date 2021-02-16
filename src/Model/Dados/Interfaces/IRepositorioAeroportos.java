package Model.Dados.Interfaces;

import Model.Negocio.Aeroporto;

public interface IRepositorioAeroportos {

    void adicionar(Aeroporto aeroporto);
    Aeroporto consultar(int id);
    void remover(Aeroporto aeroporto);
}
