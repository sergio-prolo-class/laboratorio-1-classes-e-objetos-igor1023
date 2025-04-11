package ifsc.poo;

public class Lampada {

    private boolean ligada;

    void ligar (){
        this.ligada = true;
    }

    void desligar (){
        this.ligada = false;
    }

    boolean verEstado(){
        return this.ligada;
    }

}