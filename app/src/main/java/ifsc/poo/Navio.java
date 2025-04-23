package ifsc.poo;

import java.util.Random;

public class Navio {
    
    // Constantes
    private final String[] navios = {"P", "E", "C", "S", "N"};
    private final Random aleatorio = new Random(); // VSCODE sugeriu final

    // Atributos
    private int tamanho;
    private String simbolo;
    private final int[] posicao = new int[2]; //X = posicao[0] e Y = posicao[1]
    private boolean afundou;
    private String orientacao;

    public Navio(){

        setAfundou();
        setPosicao();
        if(setSimbolo())
            setTamanho();

        setOrientacao();

    }

    private void setAfundou(){

        this.afundou = aleatorio.nextBoolean();

    }

    private void setPosicao(){

        this.posicao[0] = aleatorio.nextInt(10);
        this.posicao[1] = aleatorio.nextInt(10);

    }

    private boolean setSimbolo(){

        simbolo = navios[aleatorio.nextInt(5)];

        return simbolo != null;
    }

    private void setTamanho(){

        this.tamanho = switch(this.simbolo){

            case "P" -> 5;
            case "E" -> 4;
            case "C" -> 3;
            case "S" -> 3;
            case "N" -> 2;
            default  -> 0;

        };

    }

    private boolean setOrientacao(){

        this.orientacao = aleatorio.nextInt(1) == 1 ? "Horizontal" : "Vertical";

        return this.orientacao != null;

    }

    public String getOrientacao(){
        return this.orientacao;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public String getSimbolo(){
        return this.simbolo;
    }

    public int[] getPosicao(){
        return this.posicao;
    }

    public boolean getAfundou(){
        return this.afundou;
    }
}