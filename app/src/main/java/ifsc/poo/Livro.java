package ifsc.poo;

public class Livro {

    final int MAX_CAPITULO = 30;

    String titulo, autor;
    String generoliterario = "";
    int[] inicioCadaCapitulo = new int[MAX_CAPITULO];
    String[] nomeCadaCapitulo = new String[MAX_CAPITULO];
    int totalPagina, totalCapitulo;

    // ======== MÉTODOS DO TÍTULO ========

    void setTitulo(String titulo){

        if(titulo == null || titulo.trim().isEmpty())
            this.titulo = null;
        else this.titulo = titulo.trim();

    }

    String getTitulo(){

        return this.titulo;

    }

    // ======== MÉTODOS DO AUTOR ========
    void setAutor(String nome){
        
        if(nome == null || nome.trim().isEmpty())
            this.autor = null;
        else this.autor = nome;

    }

    String getAutor(){

        return this.autor;

    }


    // ======== MÉTODOS DOS CAPÍTULOS ========

    // Método para verificar se o vetor está ordenado
    boolean arrayOrdenado(int [] v){

        for(int i = 0; i < (v.length - 1); i++)
            if(v[i] > v[i+1])
                return false;

        return true;
    }

    // Método para verificar se as posições do vetor não estão vazias
    boolean vetorPreenchido(String[] v){

        for(int i = 0; i < v.length; i++)
            if(v[i].isEmpty())
                return false;

        return true;
    }


    void setInicioCapitulos(int[] cap){

        // O usuário pode entrar com numeros NUM de 1 a 30 (1 a MAX_CAPITULO)
        // No método, utilizaremos NUM - 1 (range de 0 a 29)
        // Ex.: inicioCadaCapitulo[0] = 5 Significa que o capítulo 1 começa na página 5

        if(cap.length <= MAX_CAPITULO && arrayOrdenado(cap))
            this.inicioCadaCapitulo = cap.clone();
        else this.inicioCadaCapitulo = null;

    }

    int[] getInicioCapitulos(){

        return this.inicioCadaCapitulo;

    }

    void setTituloCadaCapitulo(String[] cap){

        if(cap.length <= MAX_CAPITULO && vetorPreenchido(cap))
            this.nomeCadaCapitulo = cap.clone();
        else this.nomeCadaCapitulo = null;

    }

    String[] getTituloCadaCapitulo(){

        return this.nomeCadaCapitulo;

    }

    // ======== MÉTODOS DOS GÊNEROS LITERÁRIOS ========
    boolean generosCorretos(String gen){

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
    String ajustaTexto(String str){

        str = str.trim();
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

    }

    void setGeneroLiterario(String gen1, String gen2){

        if(gen1 != null)
            if((!gen1.isEmpty() || !gen1.isBlank()) && generosCorretos(gen1)){
                this.generoliterario = ajustaTexto(gen1);
                if(gen2 != null)
                    if(!gen2.isEmpty() && generosCorretos(gen2))
                        this.generoliterario += ", " + ajustaTexto(gen2);
            }

        else if(gen2 != null)
            if((!gen2.isEmpty() || !gen2.isBlank()) && generosCorretos(gen2))
                this.generoliterario = ajustaTexto(gen2);

    }

    String getGeneroLiterario(){

        return this.generoliterario;

    }


    // ======== MÉTODOS DO TOTAL DE PÁGINA ========
    void setTotalPagina(int num){

        this.totalPagina = Math.abs(num);

    }

    int getTotalPagina(){

        return this.totalPagina;

    }
}