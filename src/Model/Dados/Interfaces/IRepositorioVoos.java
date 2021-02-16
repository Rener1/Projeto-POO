package Model.Dados.Interfaces;

import Model.Negocio.Voo;

public interface IRepositorioVoos {

    void adicionar(Voo voo);
    Voo consultar(int id);
    void remover(Voo voo);
}
