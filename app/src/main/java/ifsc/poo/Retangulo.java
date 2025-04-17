package ifsc.poo;

import com.google.j2objc.annotations.RetainedWith;

/*
 * Os métodos de setar largura e altura
 * podem receber qualquer valor float, pois será
 * atribuído o módulo do valor.
*/

public class Retangulo {
    
    // Constantes
    final private int LARGURA_PADRAO = 1;
    final private int ALTURA_PADRAO = 1;

    // Atributos
    private float largura, altura;

    static Retangulo maiorArea;
    static Retangulo menorPerimetro;

    public Retangulo(float l, float a){

        this.largura = l <= 0 ? LARGURA_PADRAO : l;
        this.altura  = l <= 0 ? ALTURA_PADRAO  : a;


    }

    public void setLargura(float largura){
        this.largura = Math.abs(largura);
    }

    public void setAltura(float altura){
        this.altura = Math.abs(altura);
    }

    public float getArea(){
        return (float) (this.largura * this.altura);
    }

    public float getPerimetro(){
        return (float) (2.0 * (this.largura + this.altura));
    }

    private void atualizaDados(){



    }

    public static Retangulo getMaiorArea(){
        return maiorArea;
    }

    public static Retangulo getmenorPerimetro(){
        return menorPerimetro;
    }
}