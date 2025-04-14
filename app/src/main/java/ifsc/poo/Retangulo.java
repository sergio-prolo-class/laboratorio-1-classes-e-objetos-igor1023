package ifsc.poo;

/*
 * Os métodos de setar largura e altura
 * podem receber qualquer valor float, pois será
 * atribuído o módulo do valor.
*/

public class Retangulo {

    private float largura, altura;

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

}