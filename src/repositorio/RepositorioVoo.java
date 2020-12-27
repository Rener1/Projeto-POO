package repositorio;

import model.Aeroporto;
import model.Aviao;
import model.Voo;
import java.util.ArrayList;

public class RepositorioVoo {
    private static ArrayList<Voo> voos = new ArrayList<>();

    public void adicionarVoo(int id, Aeroporto origem, Aeroporto destino, Aviao aviao, int ano, int mes, int dia, int hora, int minuto){
        Voo voo = new Voo(id,origem,destino,aviao,ano,mes,dia,hora,minuto);
        voos.add(voo);
    }

    public Voo verificarVoo(int id){
        for (Voo voo: voos){
            if (voo.getId() == id){
                return voo;
            }
        }
        return null;
    }
}
