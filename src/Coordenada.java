public class Coordenada {
    private int graus;
    private int minutos;
    private double segundos;
    private char direcao;

    Coordenada(int graus, int minutos, double segundos, char direcao){
        this.graus = graus;
        this.minutos = minutos;
        this.segundos = segundos;
        this.direcao = direcao;
    }

    public double distanciaEntreCoordenadas(Coordenada proximaCoordenada){
        double valor1 = this.graus * 60 + this.minutos + this.segundos / 60;
        double valor2 = proximaCoordenada.graus * 60 + proximaCoordenada.minutos + proximaCoordenada.segundos / 60;
        double distancia;
        if (this.direcao == proximaCoordenada.direcao){
            distancia = Math.abs(valor1 - valor2) * 1.852;
            return distancia;
        }
        else{
            distancia = (valor1 + valor2) * 1.852;
            return distancia;
        }
    }
}
