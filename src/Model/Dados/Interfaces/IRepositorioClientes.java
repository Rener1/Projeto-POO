package Model.Dados.Interfaces;

import Model.Negocio.Cliente;

public interface IRepositorioClientes {

    void adicionar(Cliente cliente);
    Cliente consultar(String cpf);
    void remover(Cliente cliente);
}
