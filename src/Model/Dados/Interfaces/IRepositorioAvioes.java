package Model.Dados.Interfaces;

import Model.Negocio.Aviao;

public interface IRepositorioAvioes {

    void adicionar(Aviao aviao);
    Aviao consultar(int id);
    void remover(Aviao aviao);
}
