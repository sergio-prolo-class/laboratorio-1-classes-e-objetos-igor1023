package ifsc.poo;

public class Livro {

    private final int MAX_CAPITULO = 30;

    private String titulo, autor;
    private String generoliterario = "";
    private int[] inicioCadaCapitulo = new int[MAX_CAPITULO];
    private String[] nomeCadaCapitulo = new String[MAX_CAPITULO];
    private int totalPagina, totalCapitulo;

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

        if(cap.length <= MAX_CAPITULO && arrayOrdenado(cap))
            this.inicioCadaCapitulo = cap.clone();
        else this.inicioCadaCapitulo = null;

    }

    public int[] getInicioCapitulos(){

        return this.inicioCadaCapitulo;

    }

    public void setTituloCadaCapitulo(String[] cap){

        if(cap.length <= MAX_CAPITULO && vetorPreenchido(cap))
            this.nomeCadaCapitulo = cap.clone();
        else this.nomeCadaCapitulo = null;

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
    public String ajustaTexto(String str){

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


    // ======== MÉTODOS DO TOTAL DE PÁGINA ========
    public void setTotalPagina(int num){

        this.totalPagina = Math.abs(num);

    }

    public int getTotalPagina(){

        return this.totalPagina;

    }
}