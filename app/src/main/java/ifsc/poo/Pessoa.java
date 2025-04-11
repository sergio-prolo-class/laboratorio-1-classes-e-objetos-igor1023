package ifsc.poo;

public class Pessoa {

    String nome;
    int idade;

    void setNome(String nome){
        if(! (nome.equals(" ") || nome.equals("\n")))
            this.nome = nome;
        else this.nome = null;
    }

    String getNome(){
        return this.nome;
    }

    void setIdade(int idade){
        this.idade = Math.abs(idade); 
    }

    int getIdade(){
        return this.idade;
    }

    void felizAniversario(){
        this.idade++;
    }
}