package ifsc.poo;

public class Livro {

    private final int MAX_CAPITULO = 30;

    private String titulo, autor;
    private String generoliterario = "";
    private int[] inicioCadaCapitulo = new int[MAX_CAPITULO];
    private String[] nomeCadaCapitulo = new String[MAX_CAPITULO];
    private int totalPagina, totalCapitulo;
    private int paginasLidas = 0;

    // ======== MÉTODOS DO TÍTULO ========

    public void setTitulo(String titulo){

        if(titulo == null || titulo.trim().isEmpty())
            this.titulo = null;
        else this.titulo = titulo.trim();

    }

    public String getTitulo(){

        return this.titulo;

    }

    // ======== MÉTODOS DO AUTOR ========
    public void setAutor(String nome){
        
        if(nome == null || nome.trim().isEmpty())
            this.autor = null;
        else this.autor = nome;

    }

    public String getAutor(){

        return this.autor;

    }


    // ======== MÉTODOS DOS CAPÍTULOS ========

    // Método para verificar se o vetor está ordenado
    public boolean arrayOrdenado(int [] v){

        for(int i = 0; i < (v.length - 1); i++)
            if(v[i] > v[i+1])
                return false;

        return true;
    }

    // Método para verificar se as posições do vetor não estão vazias
    public boolean vetorPreenchido(String[] v){

        for(int i = 0; i < v.length; i++)
            if(v[i].isEmpty())
                return false;

        return true;
    }


    public void setInicioCapitulos(int[] cap){

        // O usuário pode entrar com numeros NUM de 1 a 30 (1 a MAX_CAPITULO)
        // No método, utilizaremos NUM - 1 (range de 0 a 29)
        // Ex.: inicioCadaCapitulo[0] = 5 Significa que o capítulo 1 começa na página 5

        if(cap.length <= MAX_CAPITULO && arrayOrdenado(cap)){
            
            this.inicioCadaCapitulo = cap.clone();
            this.totalCapitulo = cap.length;

        } else {

            this.inicioCadaCapitulo = null;
            this.totalCapitulo = 0;

        }

    }

    public int[] getInicioCapitulos(){

        return this.inicioCadaCapitulo;

    }

    public void setTituloCadaCapitulo(String[] cap){

        if(cap.length <= MAX_CAPITULO && vetorPreenchido(cap)){

            this.nomeCadaCapitulo = cap.clone();
            this.totalCapitulo = cap.length;

        } else {

            this.nomeCadaCapitulo = null;
            this.totalCapitulo = 0;

        }

    }

    public String[] getTituloCadaCapitulo(){

        return this.nomeCadaCapitulo;

    }

    // ======== MÉTODOS DOS GÊNEROS LITERÁRIOS ========
    public boolean generosCorretos(String gen){

        // Vou deixar no formato Inicial Maiuscula e o resto minusculo
        String genero = gen.trim();
        genero = genero.substring(0, 1).toUpperCase() + genero.substring(1).toLowerCase();

        switch(genero){

            case "Fantasia":
            case "Aventura":
            case "Romance":
            case "Mistério":
            case "Terror":
            case "Auto-ajuda":
            case "Pedagógico": return true;
            default: return false;

        }

    }

    // Método para formatar o texto do gênero
    private String ajustaTexto(String str){

        str = str.trim();
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

    }

    // Método para setar apenas um gênero literário.
    public void setGeneroLiterario(String gen){

        if(gen != null && (!gen.isEmpty() && !gen.isBlank()) && generosCorretos(gen))
                this.generoliterario = ajustaTexto(gen);
            
    }

    // Método para setar dois gêneros literários
    public void setGeneroLiterario(String gen1, String gen2){

        if(gen1 != null && (!gen1.isEmpty() || !gen1.isBlank()))
            if(generosCorretos(gen1)){
                this.generoliterario = ajustaTexto(gen1);
                if(gen2 != null)
                    if(!gen2.isEmpty() && generosCorretos(gen2))
                        this.generoliterario += ", " + ajustaTexto(gen2);
        }

        else if(gen2 != null && (!gen2.isEmpty() || !gen2.isBlank()))
            if(generosCorretos(gen2))
                this.generoliterario = ajustaTexto(gen2);

        /*
         * Funcionamento do meu algoritmo:
         * 1- Eu valido se gen1 é uma string não nula e não vazia;
         *      a- Eu valido se gen1 é um dos gêneros do enunciado
         *          > Se for verdadeiro, 
         *              - Ajusto o texto de gen1 e atribuo para this.generoLiterario
         *              - Faço mesmo procedimento para gen2 e concateno em this.generoLiterario
         * 
         * 2- Se gen1 for inválida, eu faço os mesmos procedimentos realizados no passo 1, porém
         * somente analiso gen2, pois gen1 já foi invalidada.
        */      

    }

    public String getGeneroLiterario(){

        return this.generoliterario;

    }


    // ======== MÉTODOS DAS PÁGINA ========
    public void setTotalPagina(int num){

        this.totalPagina = Math.abs(num);

    }

    public int getTotalPagina(){

        return this.totalPagina;

    }

    public void lerPaginas(int qtd){

        qtd = Math.abs(qtd);

        // Se não ultrpassou o limite de páginas do livro...
        if(this.paginasLidas + Math.abs(qtd) <= this.totalPagina)
            this.paginasLidas += qtd;
        else this.paginasLidas = this.totalPagina; // Vai para a última página

    }

    public void voltarPaginas(int qtd){

        qtd = Math.abs(qtd);
        if(this.paginasLidas - qtd >= 0)
            this.paginasLidas -= qtd;
        else this.paginasLidas = 0; // Volta para a primeira página
    }

    public int getPaginasLidas(){

        return this.paginasLidas;

    }

    public void reiniciarLeitura(){

        this.paginasLidas = 0;

    }

    // Imprime o número, nome e página inicial de cada capítulo
    public void imprimeSumario(){

        if(this.arrayOrdenado(inicioCadaCapitulo) && this.vetorPreenchido(nomeCadaCapitulo))
            if(inicioCadaCapitulo.length != nomeCadaCapitulo.length)
                return;
                
        System.out.println("|---------------------------SUMÁRIO---------------------------|");
        System.out.println("|Capítulo \t\tNome \t\t\t\tPágina|");

        for(int j = 0; j < this.inicioCadaCapitulo.length; j++)
            System.out.printf("|%-3d\t\t%-40s   %3d|\n", (j+1), this.nomeCadaCapitulo[j], this.inicioCadaCapitulo[j]);
                                    // %-40s para alinhar à esquerda

        System.out.println("|-------------------------------------------------------------|");
    }
}