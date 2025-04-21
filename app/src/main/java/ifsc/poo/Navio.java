package ifsc.poo;

import java.util.Random;

public class Navio {
    
    // Constantes
    private final int DIMENSAO = 10; // tabuleiro DIMENSAO x DIMENSAO
    private final String[] navio = {"P", "E", "C", "S", "N"};
    private final Random aleatorio = new Random(); // VSCODE sugeriu final

    // Atributos
    private int tamanho;
    private String simbolo;
    private int[] posicao = new int[2];
    private boolean afundou;

    public Navio(){

        setAfundou();
        setPosicao();
        if(setSimbolo())
            setTamanho();

    }

    private void setAfundou(){

        this.afundou = aleatorio.nextBoolean();

    }

    private void setPosicao(){

        this.posicao[0] = aleatorio.nextInt(10);
        this.posicao[1] = aleatorio.nextInt(10);

    }

    private boolean setSimbolo(){

        simbolo = navio[aleatorio.nextInt(5)];

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
}