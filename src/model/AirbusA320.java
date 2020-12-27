package model;

public class AirbusA320 extends Aviao{
    public AirbusA320(Localizacao localizacao){
        super(localizacao);
        this.modelo = "Airbus A320";
        this.velocidadeCruzeiro = 963.14;
        this.capacidadePassageiros[0] = 180;
        this.capacidadePassageiros[1] = 156;
    }
}
