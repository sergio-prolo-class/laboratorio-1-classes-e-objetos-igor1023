package ifsc.poo;

public class Lampada {

    private boolean ligada;
    private static int quantidadeLampadas = 0;

    public Lampada(){
        this.ligada = false; // Já é padrão...
        quantidadeLampadas++;
    }

    public Lampada(boolean estado){
        this.ligada = estado;
        quantidadeLampadas++;
    }

    public boolean ligar (){
        return this.ligada = true;
    }

    public boolean desligar (){
        return this.ligada = false;
    }

    public boolean verEstado(){
        return this.ligada;
    }

    public static int getQuantidadeLampadas(){
        return quantidadeLampadas;
    }

}