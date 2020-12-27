package repositorio;

import model.Cliente;
import java.util.ArrayList;

public class RepositorioCliente {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public static Cliente verificarCliente(int cpf){
        for (Cliente cliente: clientes){
            if (cliente.getCpf() == cpf){
                return cliente;
            }
        }
        return null;
    }

    public static void atualizarCliente(int cpf, String nome){
        Cliente cliente = verificarCliente(cpf);
        cliente.setNome(nome);
    }

    public static void deletarCliente(int cpf){
        Cliente cliente = verificarCliente(cpf);
        clientes.remove(cliente);
    }
}
