package ifsc.poo;

/*
 * O usuário pode entrar com qualquer valor int para a idade, 
 * pois será utilizado o módulo deste valor.
*/

public class Pessoa {

    private String nome;
    private int idade;

    public void setNome(String nome){
        if(! (nome.equals(" ") || nome.equals("\n")))
            this.nome = nome;
        else this.nome = null;
    }

    public String getNome(){
        return this.nome;
    }

    public void setIdade(int idade){
        this.idade = Math.abs(idade); 
    }

    public int getIdade(){
        return this.idade;
    }

    public void felizAniversario(){
        this.idade++;
    }
}