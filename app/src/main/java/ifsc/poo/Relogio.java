package ifsc.poo;

/*
 * Os métodos de setar hora, minuto e segundo
 * podem receber qualquer valor float, pois será
 * atribuído o módulo do valor.
*/

public class Relogio {

    private byte hora, minuto, segundo;

    public Relogio(byte hora){

        this(hora, (byte) 0, (byte) 0);

    }    

    public Relogio(byte hora, byte minuto){

        this(hora, minuto, (byte) 0);

    }   

    public Relogio(byte hora, byte minuto, byte segundo){

        this.ajustaHora(hora, minuto, segundo);

    }

    private void ajustaHora(byte hora, byte minuto, byte segundo){

        // Se hora for maior que 23, será 0
        // Se minuto ou segundo for maior ou igual que 60, será 0

        if(segundo >= 60 || segundo < 0)
            this.segundo = 0; 
        else this.segundo = segundo;
        
        if(minuto >= 60 || minuto < 0)
            this.minuto = 0;
        else this.minuto = minuto;
        
        if(hora >= 24 || hora < 0)
            this.hora = 0;
        else this.hora = hora;

    }

    public byte getHora(){
        return this.hora;
    }

    public byte getMinuto(){
        return this.minuto;
    }

    public byte getSegundo(){
        return this.segundo;
    }

    public String getHoraFormatoV1(){

        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);

    }

    public String getHoraFormatoV2(){

        String horario = "";
        if(this.hora <= 12){

            if(this.hora < 10)
                horario += "0" + (this.hora) + "am ";
            else if(this.hora == 12 && this.minuto == 0 && this.segundo == 0)
                horario += this.hora + "am ";
            else horario += this.hora + "pm ";

        } else {

            if(this.hora - 12 < 10)
                horario += "0" + (this.hora - 12) + "pm ";
            else horario += (this.hora - 12) + "pm ";

        }

        // As duas seguintes linhas abaixo analisam, respectivamente, minuto
        // e segundo para concatenação do 0.
        horario += this.minuto < 10 ? "0" + this.minuto + "m " : this.minuto + "m ";
        horario += this.segundo < 10 ? "0" + this.segundo + "s " : this.segundo + "s ";

        return horario;

    }

    public void avancaHora(){

        this.hora++;

        if(hora == 24)
            this.hora = 0;

    }

    public void avancaMinuto(){

        this.minuto++;

        if(minuto == 60){
            this.minuto = 0;
            avancaHora();
        }

    }

    public void avancaSegundo(){

        this.segundo++;

        if(this.segundo == 60){
            this.segundo = 0;
            avancaMinuto();
        }

    }

    // ========= MÉTODOS PARA A DIFERENÇA ENTRE DOIS HORARIOS ==========
    // Converte um um relogio (hh:mm:ss) para segundo
    private int horarioToSegundo(Relogio r){

        return r.hora * 3600 + r.minuto * 60 + r.segundo;

    }

    // Retorna o módulo da diferença entre dois horarios
    public int diffRelogios(Relogio r1, Relogio r2){

        return Math.abs(horarioToSegundo(r1) - horarioToSegundo(r2));

    }

    // ========= MÉTODO PARA SINCRONIZAR DOIS RELOGIOS ========
    // O Relogio R1 será sincronizado com o horário do Relógio R2
    public static boolean sincronizarRelogios(Relogio r1, Relogio r2){

        if(r1 == null || r2 == null)
            return false;

        r1.ajustaHora(r2.getHora(), r2.getMinuto(), r2.getSegundo());

        return true;

    }

}