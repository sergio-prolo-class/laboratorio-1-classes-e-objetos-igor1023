package ifsc.poo;

/*
 * O usuário pode entrar com qualquer valor int para a idade, 
 * pois será utilizado o módulo deste valor.
*/

public class Pessoa {

    private String nome;
    private int idade;

    public void setNome(String nome){
        if(nome == null || nome.isEmpty() || nome.isBlank())
            this.nome = null;
        else this.nome = ajustaNome(nome);
    }

    private String ajustaNome(String str){

        str = str.trim();
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        return str;

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