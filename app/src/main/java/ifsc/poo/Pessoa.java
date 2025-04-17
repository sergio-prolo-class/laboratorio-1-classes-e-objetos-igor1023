package ifsc.poo;

/*
 * O usuário pode entrar com qualquer valor int para a idade, 
 * pois será utilizado o módulo deste valor.
*/

public class Pessoa {

    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(){
        setCpf("123.456.789-00");
        setNome("");
        setIdade(0);
    }

    public Pessoa(String cpf){

        setCpf(cpf);
        this.nome = "";
        this.idade = 0;
    }

    public Pessoa(String cpf, String nome){

        setCpf(cpf);
        setNome(nome);
        this.idade = 0;
    }   

    public Pessoa(String cpf, String nome, int idade){

        setCpf(cpf);
        setNome(nome);
        setIdade(idade);

    }

    private String formatoCpfCorreto(String str){

        if(str == null)
            return null;

        if(! (str.isEmpty() && str.isBlank()))
            return str;
        
        return "123.456.789-00";        

    }

    private boolean setCpf(String cpf){

        this.cpf = formatoCpfCorreto(cpf);
        return this.cpf != null;

    }

    public String getCpf(){

        return this.cpf;

    }

    public boolean setNome(String nome){

        this.nome = ajustaNome(nome);
        return this.nome != null;
    }

    private String ajustaNome(String str){

        if(str == null || str.isEmpty() || str.isBlank()) {
            return null;
        }

        str = str.trim();
        str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        return str;

    }

    public String getNome(){
        return this.nome;
    }

    public boolean setIdade(int idade){
        
        if(idade < 0){
            this.idade = 0;
            return false;
        }
        
        this.idade = idade;
        return true; 
    }

    public int getIdade(){
        return this.idade;
    }

    public void felizAniversario(){
        this.idade++;
    }
}