package repositorio;

import model.Voo;
import java.util.ArrayList;

public class RepositorioVoo {
    private static final ArrayList<Voo> voos = new ArrayList<>();

    public static void adicionarVoo(Voo voo){
        voos.add(voo);
    }

    public static Voo verificarVoo(int id){
        for (Voo voo: voos){
            if (voo.getId() == id){
                return voo;
            }
        }
        return null;
    }
}
