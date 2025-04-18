package ifsc.poo;

/*
 * (e) Você acha que a modelagem desse produto é boa? Se não, onde você mudaria algo, e por
 * que? Faça um comentário no seu código fonte incluindo essa resposta.
 * 
 * Trabalhar com preco e desconto com float ou double.
 * Como sistema monetário tem apenas duas casas para os centavos, poderia utilizar float
 * Se for para trabalhar o preco com int, o que aconteceria com os centavos?
 * 
 * Os métodos de setar preco podem receber qualquer valor float, 
 * pois será atribuído o módulo do valor.
*/

public class Produto {
    
    private String nome;
    private int preco = 0;
    private int desconto = 0; //caso não tenha desconto, o usuário não precisa definir

    public void setNome(String nome){
        
        if(nome == null || nome.isEmpty() || nome.isBlank())
            this.nome = "ERROR"; //Ou null e o usuário faz as tratativas no seu código
        else this.nome = ajustaTexto(nome);
        // String.trim(): remover espaços desnecessários
        // lembrei que o professor de Prog II passou um exercício deste em C
        // e nos comentou que em java isto já vem pronto. 
        
    }

    // Método apenas da classe para ajustar strings casuais
    private String ajustaTexto(String str){

        str = str.trim(); // Vou remover espaços iniciais e finais

        // Vou deixar a String com a inicial MAIUSCULA e o restante minusculo
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        return str;

    }

    public String getNome(){

        return this.nome;

    }

    public void setPreco(int preco){
        this.preco = Math.abs(preco);
        // recebe o modulo do valor caso usuário entre com
        // numero negativo sem a intenção
    }   

    public float getPreco(){
        
        return this.preco - (this.desconto * this.preco / 100.0f);

    }

    public void setDesconto(int desconto){

        // Para um desconto de 12%, este método atribui 12 para this.desconto
        this.desconto = Math.abs(desconto);

    }

    public int getDesconto(){

        return this.desconto;
        
    }

    public String anuncio(){

        return String.format("%s: de R$ %.2f por APENAS R$ %.2f!", getNome(), (float) getPreco(), (float) getPreco());

    }
}