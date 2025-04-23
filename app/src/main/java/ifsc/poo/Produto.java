package ifsc.poo;

/*
 * (e) Você acha que a modelagem desse produto é boa? Se não, onde você mudaria algo, e por
 * que? Faça um comentário no seu código fonte incluindo essa resposta.
 * 
 * Trabalhar com preco e desconto com float ou double.
 * Como sistema monetário tem apenas duas casas para os centavos, poderia utilizar float
 * Se for para trabalhar o preco com int, o que aconteceria com os centavos?
 * 
*/

public class Produto {
    
    // Constantes
    private final static int MAX_REGISTROS = 50;

    // Atributos para o registro
    private static Produto[] registros = new Produto[MAX_REGISTROS];
    private static int inicio = 0; // inicio da fila
    private static int fim = 0; // fim da fila
    private static int tamanho = 0; // tamanho
    private static int quantidadeProduto = 0;

    // Atributos de um Produto
    private String nome, codigo;
    private int preco = 0;
    private int desconto = 0; //caso não tenha desconto, o usuário não precisa definir

    public Produto(String nome, int preco) {

        setNome(nome);
        setPreco(preco);
        this.desconto = 0;
        registrarProduto(this);

        quantidadeProduto++;
        codigo = codigoAjustado(quantidadeProduto);

    }

    // Método para adicionar na fila circular
    private static void registrarProduto(Produto prod){

        registros[fim] = prod;
        fim = (fim + 1) % MAX_REGISTROS;

        if(tamanho < MAX_REGISTROS)
            tamanho++;
        else inicio = (inicio + 1) % MAX_REGISTROS; // Caso da fila cheia

    }

    public static String[] getRegistros(){

        if(registros == null || tamanho == 0)
            return new String[0];

        String[] reg = new String[tamanho + 1]; // +1 devido a linha abaixo
        reg[0] = "Código;Nome;Preço;Desconto";

        for(int i = 0; i < tamanho; i++){

            int indice = (inicio + i) % MAX_REGISTROS;
            Produto prod = registros[indice];
            
            if(prod != null)
                reg[i+1] = String.format("%s;%s;%.2f;%d", prod.getCodigo(), prod.getNome(), prod.getPreco(), prod.getDesconto());

        }

        return reg;

    }

    private String codigoAjustado(int qtd){
        
        return String.format("%03d-%03d", (qtd / 1000), (qtd % 1000));

    }

    public boolean setNome(String nome){
        
        if(nome == null || nome.isEmpty() || nome.isBlank()){
            this.nome = "ERROR"; //Ou null e o usuário faz as tratativas no seu código
            return false;
        } 
        
        this.nome = ajustaTexto(nome);
        return true;
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

    public String getCodigo(){

        return this.codigo;

    }

    public boolean setPreco(int preco){
        
        if(preco < 0) {
            this.preco = 0;
            return false;
        }

        this.preco = preco;
        return true;
    
    }   

    public float getPreco(){
        
        return this.preco - (this.desconto * this.preco / 100.0f);

    }

    public boolean setDesconto(int desconto){

        if(desconto < 0){
            this.desconto = 0;
            return false;
        }
        // Para um desconto de 12%, este método atribui 12 para this.desconto
        this.desconto = desconto;
        return true;

    }

    public int getDesconto(){

        return this.desconto;
        
    }

    private float descontoAplicado(){

        return this.getPreco() - (this.getPreco() * this.getDesconto() / 100.0f);

    }

    public String anuncio(){

        return String.format("%s: de R$ %.2f por APENAS R$ %.2f!", getNome(), (float) getPreco(), descontoAplicado());

    }
}