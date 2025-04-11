package ifsc.poo;

public class Livro{

    final int MAX = 30;

    String titulo, autor;
    String generoliterario = "";
    int[] inicioCadaCapitulo = new int[MAX];
    String[] nomeCadaCapitulo = new String[MAX];
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


    // ======== MÉTODOS DO AUTOR  ========
    void setAutor(String nome){
        
        if(nome == null || nome.trim().isEmpty())
            this.autor = null;
        else this.autor = nome;

    }

    String getAutor(){

        return this.autor;

    }


    // ======== MÉTODOS DOS CAPÍTULOS  ========

    // Método para verificar se o vetor está ordenado
    boolean arrayOrdenado(int [] v){

        for(int i = 0; i < (v.length - 1); i++)
            if(v[i] > v[i+1])
                return false;

        return true;
    }

    // Método para verificar se as posições do vetor não está vazias
    boolean vetorPreenchido(String[] v){

        for(int i = 0; i < v.length; i++)
            if(v[i].isEmpty())
                return false;

        return true;
    }


    void setInicioCapitulos(int[] cap){

        // O usuário pode entrar com numeros NUM de 1 a 30
        // No método, utilizaremos NUM - 1 (range de 0 a 29)
        // Ex.: inicioCadaCapitulo[0] = 5 Significa que o capítulo 1 começa na página 5

        if(cap.length <= MAX && arrayOrdenado(cap))
            this.inicioCadaCapitulo = cap.clone();
            
    }

    int[] getInicioCapitulos(){

        return inicioCadaCapitulo;

    }

    void setTituloCadaCapitulo(String[] cap){

        if(cap.length <= MAX && vetorPreenchido(cap))
            this.nomeCadaCapitulo = cap.clone();

    }

    String[] getTituloCadaCapitulo(){

        return this.nomeCadaCapitulo;

    }

    // ======== MÉTODOS DOS GÊNEROS LITERÁRIOS  ========
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

    void setGeneroLiterario(String gen1, String gen2){

        if(gen1 != null)
            if(generosCorretos(gen1)){
                this.generoliterario = gen1;
                if(gen2 != null)
                    if(generosCorretos(gen2))
                        this.generoliterario += ", " + gen2;
            }

        else if(gen2 != null)
            if(generosCorretos(gen2))
                this.generoliterario = gen2;

        /* if(gen1 != null && gen2 != null)
            this.generoliterario = gen1 + " " + gen2;
        else if(gen1 == null && gen2 != null)
            this.generoliterario = gen2;
        else if(gen1 != null && gen2 == null)
            this.generoliterario = gen1;
        else this.generoliterario = null; */
    }

    String getGeneroLiterario(){

        return this.generoliterario;

    }


    // ======== MÉTODOS DO TOTAL DE PÁGINA  ========
    void setTotalPagina(int num){

        this.totalPagina = Math.abs(num);

    }

    int getTotalPagina(){

        return this.totalPagina;

    }
}