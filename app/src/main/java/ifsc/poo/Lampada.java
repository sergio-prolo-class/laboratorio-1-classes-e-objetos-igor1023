package ifsc.poo;

public class Lampada {

    private boolean ligada;
    private int quantidadeLampadas = 0;

    public Lampada(){
        this.ligada = false; // Já é padrão...
        this.quantidadeLampadas++;
    }

    public Lampada(boolean estado){
        this.ligada = estado;
        this.quantidadeLampadas++;
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

    public int quantidadeLampadas(){
        return this.quantidadeLampadas;
    }

}