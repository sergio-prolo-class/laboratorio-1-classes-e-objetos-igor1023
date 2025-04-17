package ifsc.poo;

public class Retangulo {
    
    // Constantes
    final private int LARGURA_PADRAO = 1;
    final private int ALTURA_PADRAO = 1;

    // Atributos
    private float largura, altura;

    // Forço ambos serem nulo para receberem o primeiro objeto
    // retângulo criado
    private static Retangulo maiorArea = null;
    private static Retangulo menorPerimetro = null;

    public Retangulo(float l, float a){

        this.setLargura(l);
        this.setAltura(a);
        atualizaDados();

    }

    public void setLargura(float l){
        this.largura = l <= 0 ? LARGURA_PADRAO : l;    
    }

    public void setAltura(float a){
        this.altura = a <= 0 ? ALTURA_PADRAO  : a;    
    }

    public float getArea(){
        return (float) (this.largura * this.altura);
    }

    public float getPerimetro(){
        return (float) (2.0 * (this.largura + this.altura));
    }

    private void atualizaDados(){

        if(maiorArea == null || maiorArea.getArea() < this.getArea())
            maiorArea = this;
        
        if(menorPerimetro == null || menorPerimetro.getPerimetro() > this.getPerimetro())
                menorPerimetro = this;
        
    }

    public static Retangulo getMaiorArea(){
        return maiorArea;
    }

    public static Retangulo getMenorPerimetro(){
        return menorPerimetro;
    }
}