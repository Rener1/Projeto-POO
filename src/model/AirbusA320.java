package model;

public class AirbusA320 extends Aviao{
    public AirbusA320(Localizacao localizacao){
        this.modelo = "Airbus A320";
        this.status = "Parado";
        this.velocidadeCruzeiro = 963.14;
        capacidadePassageiros[0] = 180;
        capacidadePassageiros[1] = 156;
        this.localizacao = localizacao;
    }
}
