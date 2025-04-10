package ifsc.poo;

public class Retangulo {

    float largura, altura;

    void setLargura(float largura){
        this.largura = Math.abs(largura);
    }

    void setAltura(float altura){
        this.altura = Math.abs(altura);
    }

    float getArea(){
        return (float) (this.largura * this.altura);
    }

    float getPerimetro(){
        return (float) (2.0 * (this.largura + this.altura));
    }

}