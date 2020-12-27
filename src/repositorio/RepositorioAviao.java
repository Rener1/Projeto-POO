package repositorio;

import model.Aviao;
import java.util.ArrayList;

public class RepositorioAviao {
    private static final ArrayList<Aviao> avioes = new ArrayList<>();

    public static void adicionarAviao(Aviao aviao){
        avioes.add(aviao);
    }

    public static Aviao verificarAviao(int id){
        for (Aviao aviao: avioes){
            if (aviao.getId() == id){
                return aviao;
            }
        }
        return null;
    }
}
