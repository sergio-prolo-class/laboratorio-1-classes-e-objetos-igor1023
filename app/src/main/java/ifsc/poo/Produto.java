package ifsc.poo;

/*
 * (e) Você acha que a modelagem desse produto é boa? Se não, onde você mudaria algo, e por
 * que? Faça um comentário no seu código fonte incluindo essa resposta.
 * 
 * Trabalhar com preco e desconto com float ou double.
 * Como sistema monetário tem apenas duas casas para os centavos, poderia utilizar float
 * Se for para trabalhar o preco com int, o que aconteceria com os centavos?
*/

public class Produto {
    
    String nome;
    int preco = 0;
    int desconto = 0; //caso não tenha desconto, o usuário não precisa definir

    void setNome(String nome){
        
        if(nome == null || nome.trim().isEmpty())
            this.nome = "ERROR"; //Ou null e o usuário faz as tratativas
        else this.nome = nome.trim();
        // String.trim(): remover espaços desnecessários
        // lembrei que o professor de Prog II passou um exercício deste em C
        // e nos comentou que em java isto já vem pronto. 
        
    }

    String getNome(){
        return this.nome;
    }

    void setPreco(int preco){
        this.preco = Math.abs(preco);
        // recebe o modulo do valor caso usuário entre com
        // numero negativo sem a intenção
    }   

    float getPreco(){
        
        return this.preco - (this.desconto * this.preco / 100.0f);

    }

    void setDesconto(int desconto){

        this.desconto = Math.abs(desconto);

    }

    int getDesconto(){

        return this.desconto;
        
    }

    String anuncio(){

        return String.format("%s: de R$ %.2f por APENAS R$ %.2f !", this.nome, (float) this.preco, (float) getPreco());

    }
}